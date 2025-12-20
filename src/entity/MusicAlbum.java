package entity;

import service.utils.Validator;

import java.util.ArrayList;
import java.util.Objects;

public class MusicAlbum extends AudioItem{
     private String label;
     private ArrayList<Song> songsList;

    public MusicAlbum(String title, String author, String genre, int durationSec, String category, int releaseYear, String label, ArrayList<Song> songsList) {
        super(title, author, genre, durationSec, category, releaseYear);
        Validator.validateString(label, "Label");

        this.label = label;
        this.songsList = Objects.requireNonNullElseGet(songsList, ArrayList::new);

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
