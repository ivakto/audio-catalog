package entity;

import java.util.ArrayList;
import java.util.Objects;

public class MusicAlbum extends AudioItem{
     private String albumName;
     private String label;
     private ArrayList<Song> songsList;

    public MusicAlbum(String genre, int durationSec, String category, String author, int releaseYear, String albumName, String label, ArrayList<Song> songsList) {
        super(genre, durationSec, category, author, releaseYear);
        if (albumName == null || albumName.isEmpty()) {
            throw new IllegalArgumentException("Album name cannot be null!");
        }
        if (label == null || label.isEmpty()) {
            throw new IllegalArgumentException("Label cannot be null!");
        }

        this.albumName = albumName;
        this.label = label;

        this.songsList = Objects.requireNonNullElseGet(songsList, ArrayList::new);
        // Средата ми поправи if-else на .requireNonNullElseGet()
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(ArrayList<Song> songsList) {
        this.songsList = songsList;
    }
}
