package service.io;

import entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class LibraryRepository {

    public static final String FILE_NAME = "library.csv";
    public static final String DELIMITER = ";";

    public static void save(List<AudioItem> items) {
        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FILE_NAME));
            buffWriter.write("TYPE;ID;TITLE;GENRE;DURATION;CATEGORY;AUTHOR;YEAR;EXTRA_INFO");
            buffWriter.newLine();

            for(AudioItem item:items) {
                StringBuilder line = new StringBuilder();

                switch (item) {
                    case Song song1 -> line.append("SONG");
                    case EBook eBook -> line.append("EBOOK");
                    case MusicAlbum musicAlbum -> line.append("MUSICALBUM");
                    case Podcast podcast -> line.append("PODCAST");
                    case null, default -> line.append("UNKNOWN");
                }

                line.append(DELIMITER);

                assert item != null; // предложено от средата
                line.append(item.getId()).append(DELIMITER);
                line.append(item.getTitle()).append(DELIMITER);
                line.append(item.getGenre()).append(DELIMITER);
                line.append(item.getDurationSec()).append(DELIMITER);
                line.append(item.getCategory()).append(DELIMITER);
                line.append(item.getAuthor()).append(DELIMITER);
                line.append(item.getReleaseYear()).append(DELIMITER);

                switch (item) {
                    case Song song -> {
                        line.append(song.getLyrics()).append(DELIMITER);
                        line.append(song.getRating());
                    }
                    case EBook eBook -> {
                        line.append(eBook.getNumberOfChapters()).append(DELIMITER);
                        line.append(eBook.getLanguage());
                    }
                    case MusicAlbum musicAlbum -> {
                        line.append(musicAlbum.getSongsList()).append(DELIMITER);
                        line.append(musicAlbum.getLabel());
                    }
                    case Podcast podcast -> {
                        line.append(podcast.getDescription()).append(DELIMITER);
                        line.append(podcast.getEpisodesNum());
                    }
                    default -> {
                    }
                }

                buffWriter.write(line.toString());
                buffWriter.newLine();
            }
            buffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<AudioItem> load() {
        List<AudioItem> library = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return library;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER, -1);
                if (data.length < 8) continue;

                String type = data[0];
                UUID id = UUID.fromString(data[1]);
                String title = data[2];
                String genre = data[3];
                int duration = Integer.parseInt(data[4]);
                String category = data[5];
                String author = data[6];
                int year = Integer.parseInt(data[7]);

                String extra1 = (data.length > 8) ? data[8] : "";
                String extra2 = (data.length > 9) ? data[9] : "0";

                AudioItem item = null;

                switch (type) {
                    case "SONG" -> {
                        int rating = extra2.isEmpty() ? 0 : (int) Double.parseDouble(extra2);
                        String lyrics = extra1.isEmpty() ? "Instrumental" : extra1;
                        item = new Song(title, author, genre, duration, category, year, rating, lyrics);
                    }
                    case "PODCAST" -> {
                        String desc = extra1.isEmpty() ? "No description provided" : extra1;
                        int episodes = extra2.isEmpty() ? 0 : Integer.parseInt(extra2);
                        item = new Podcast(title, author, genre, duration, category, year, episodes, desc);
                    }
                    case "EBOOK" -> {
                        int chapters = extra1.isEmpty() ? 0 : Integer.parseInt(extra1);
                        String language = extra2.isEmpty() ? "Unknown" : extra2;
                        item = new EBook(title, author, genre, duration, category, year, chapters, language);
                    }
                    case "MUSICALBUM" -> {
                        ArrayList<Song> emptySongs = new ArrayList<>();
                        String label = extra2.isEmpty() ? "Indie Label" : extra2;
                        item = new MusicAlbum(title, author, genre, duration, category, year, label, emptySongs);
                    }
                }

                if (item != null) {
                    item.setId(id);
                    library.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading file.");
        }

        return library;
    }

}
