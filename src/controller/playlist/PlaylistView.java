package controller.playlist;

import entity.AudioItem;
import entity.Playlist;
import entity.PlaylistInsertable;

public class PlaylistView {

    public void print(Playlist playlist) {
        System.out.println("\nCONTENT OF: " + playlist.getTitle());

        if (playlist.getItemsList().isEmpty()) {
            System.out.println("(Playlist is empty)");
        } else {
            int index = 1;
            for (PlaylistInsertable element : playlist.getItemsList()) {
                if (element instanceof AudioItem) {
                    AudioItem item = (AudioItem) element;
                    System.out.println(index++ + ". " + item.getTitle() + " (" + item.getAuthor() + ") [" + item.getCategory() + "]");
                }
            }
        }
    }
}
