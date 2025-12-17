package entity;

import java.util.ArrayList;
import java.util.Objects;

public class MusicAlbum extends AudioItem{
     private String label;
     private ArrayList<Song> songsList;

    public MusicAlbum(String genre, int durationSec, String category, String title, String author, int releaseYear, String label, ArrayList<Song> songsList) {
        super(genre, durationSec, category, author, releaseYear, title);
        if (label == null || label.isEmpty()) {
            throw new IllegalArgumentException("Label cannot be null!");
        }
        this.label = label;
        this.songsList = Objects.requireNonNullElseGet(songsList, ArrayList::new);
        // Средата ми поправи if-else на .requireNonNullElseGet()
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
