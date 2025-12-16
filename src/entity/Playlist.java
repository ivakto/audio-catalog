package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist extends AudioItem implements PlaylistInsertable{
    private String playlistName;
    private boolean isPublic;
    private ArrayList<PlaylistInsertable> itemsList;

    public Playlist(String genre, int durationSec, String category, String author, int releaseYear, String playlistName, boolean isPublic, ArrayList<PlaylistInsertable> itemsList) {
        super(genre, durationSec, category, author, releaseYear);
        if (playlistName == null || playlistName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        this.playlistName = playlistName;
        this.isPublic = isPublic;
        this.itemsList = Objects.requireNonNullElseGet(itemsList, ArrayList::new);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public ArrayList<PlaylistInsertable> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<PlaylistInsertable> itemsList) {
        this.itemsList = itemsList;
    }
}
