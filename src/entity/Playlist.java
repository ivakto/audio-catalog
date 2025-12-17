package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist extends AudioItem implements PlaylistInsertable{
    private boolean isPublic;
    private ArrayList<PlaylistInsertable> itemsList;

    public Playlist(String genre, int durationSec, String category, String title, String author, int releaseYear, boolean isPublic, ArrayList<PlaylistInsertable> itemsList) {
        super(genre, durationSec, category, author, releaseYear, title);

        this.isPublic = isPublic;
        this.itemsList = Objects.requireNonNullElseGet(itemsList, ArrayList::new);
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
