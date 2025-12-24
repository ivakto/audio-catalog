package io;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryRepository {

    private static final String FILE_NAME = "library.csv";

    public void save(List<AudioItem> library) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_NAME))) {
            String[] header = {
                    "ID", "TYPE", "TITLE", "GENRE", "DURATION", "CATEGORY", "AUTHOR", "YEAR", "RATING", "LYRICS",
                    "CHAPTERSNUM", "LANGUAGE", "EPISODESNUM", "DESCRIPTION", "LABEL", "SONGSLIST",
                    "ISPUBLIC", "ITEMSLIST"
            };
            writer.writeNext(header);

            for (AudioItem item : library) {
                String[] data = convertItemToArray(item);
                writer.writeNext(data);
            }
            System.out.println("Data saved successfully to " + FILE_NAME);

        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file", e);
        }
    }

    public List<AudioItem> load() {
        List<AudioItem> library = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return library;

        try (CSVReader reader = new CSVReader(new FileReader(FILE_NAME))) {
            reader.readNext(); // Skip Header

            String[] row;
            while ((row = reader.readNext()) != null) {
                AudioItem item = parseRowToItem(row);
                if (item != null) {
                    library.add(item);
                }
            }
            reconnectPlaylistItem(library, FILE_NAME);

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return library;
    }

    private AudioItem parseRowToItem(String[] row) {
        if (row.length < 18) return null;

        try {
            String id = row[0];
            String type = row[1];
            String title = row[2];
            String genre = row[3];
            int duration = Integer.parseInt(row[4]);
            String category = row[5]; // ЕТО Я КАТЕГОРИЯТА
            String author = row[6];
            int releaseYear = Integer.parseInt(row[7]);

            AudioItem item = null;

            switch (type) {
                case "SONG":
                    int rating = row[8].isEmpty() ? -1 : Integer.parseInt(row[8]);
                    String lyrics = row[9];
                    item = new Song(title, author, genre, duration, category, releaseYear, rating, lyrics);
                    break;

                case "EBOOK":
                    int chapters = row[10].isEmpty() ? -1 : Integer.parseInt(row[10]);
                    String language = row[11];
                    item = new EBook(title, author, genre, duration, category, releaseYear, chapters, language);
                    break;

                case "PODCAST":
                    int episodes = row[12].isEmpty() ? -1 : Integer.parseInt(row[12]);
                    String description = row[13];
                    item = new Podcast(title, author, genre, duration, category, releaseYear, episodes, description);
                    break;

                case "MUSICALBUM":
                    String label = row[14];
                    item = new MusicAlbum(title, author, genre, duration, category, releaseYear, label, new ArrayList<>());
                    break;

                case "PLAYLIST":
                    boolean isPub = Boolean.parseBoolean(row[16]);
                    item = new Playlist(title, author, genre, duration, category, releaseYear, isPub, new ArrayList<>());
                    break;
            }

            if (item != null) {
                item.setId(id);
            }
            return item;

        } catch (Exception e) {
            System.out.println("Skipping invalid row: " + e.getMessage());
            return null;
        }
    }

    private String[] convertItemToArray(AudioItem item) {
        // Вече item.getId() връща String, така че махаме .toString()
        String id = item.getId();
        String type = "";
        String title = item.getTitle();
        String genre = item.getGenre();
        String duration = String.valueOf(item.getDurationSec());
        String category = (item.getCategory() == null) ? "" : item.getCategory();
        String author = item.getAuthor();
        String releaseYear = String.valueOf(item.getReleaseYear());

        String rating = "", lyrics = "", chaptersNum = "", language = "", episodesNum = "", description = "",
                label = "", songsList = "", isPublic = "", itemsList = "";

        if (item instanceof Song s) {
            type = "SONG";
            rating = (s.getRating() == -1) ? "" : String.valueOf(s.getRating());
            lyrics = (s.getLyrics() == null) ? "" : s.getLyrics();
        } else if (item instanceof EBook e) {
            type = "EBOOK";
            chaptersNum = (e.getNumberOfChapters() == -1) ? "" : String.valueOf(e.getNumberOfChapters());
            language = (e.getLanguage() == null) ? "" : e.getLanguage();
        } else if (item instanceof Podcast p) {
            type = "PODCAST";
            episodesNum = (p.getEpisodesNum() == -1) ? "" : String.valueOf(p.getEpisodesNum());
            description = (p.getDescription() == null) ? "" : p.getDescription();
        } else if (item instanceof MusicAlbum a) {
            type = "MUSICALBUM";
            label = (a.getLabel() == null) ? "" : a.getLabel();
            songsList = getIdsAsString(a.getSongsList());
        } else if (item instanceof Playlist pl) {
            type = "PLAYLIST";
            isPublic = String.valueOf(pl.isPublic());
            itemsList = getIdsAsString(pl.getItemsList());
        }

        return new String[] {
                id, type, title, genre, duration, category, author, releaseYear, rating,
                lyrics, chaptersNum, language, episodesNum, description, label, songsList,
                isPublic, itemsList
        };
    }

    private void reconnectPlaylistItem(List<AudioItem> library, String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            reader.readNext(); // Skip Header
            String[] row;

            while ((row = reader.readNext()) != null) {
                if ("PLAYLIST".equals(row[1]) || "MUSICALBUM".equals(row[1])) {
                    // Тук ID-то е String
                    String containerId = row[0];
                    String idsString = "PLAYLIST".equals(row[1]) ? row[17] : row[15];

                    if (idsString.length() > 2) {
                        String cleanIds = idsString.replace("[", "").replace("]", "");
                        String[] idsArray = cleanIds.split(",");
                        AudioItem container = findById(library, containerId);

                        for (String idStr : idsArray) {
                            if (!idStr.trim().isEmpty()) {
                                String itemId = idStr.trim();
                                AudioItem childItem = findById(library, itemId);

                                if (container instanceof Playlist p && childItem instanceof PlaylistInsertable) {
                                    p.getItemsList().add((PlaylistInsertable) childItem);
                                } else if (container instanceof MusicAlbum a && childItem instanceof Song) {
                                    a.getSongsList().add((Song) childItem);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private AudioItem findById(List<AudioItem> library, String id) {
        for (AudioItem item : library) {
            if (item.getId().equals(id)) return item;
        }
        return null;
    }

    private String getIdsAsString(List<?> items) {
        if (items == null || items.isEmpty()) return "[]";
        List<String> ids = new ArrayList<>();
        for (Object obj : items) {
            if (obj instanceof AudioItem) {
                ids.add(((AudioItem) obj).getId());
            }
        }
        return ids.toString();
    }
}