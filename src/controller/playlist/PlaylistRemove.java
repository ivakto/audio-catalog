package controller.playlist;

import controller.InputProvider;
import entity.AudioItem;
import entity.Playlist;

import java.util.Scanner;

public class PlaylistRemove {
    private final InputProvider inputProvider;

    public PlaylistRemove(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void remove(Playlist playlist) {
        String titleToRemove = inputProvider.readString("Enter title of item to remove: ");

        boolean removed = playlist.getItemsList().removeIf(element -> {
            if (element instanceof AudioItem) {
                return ((AudioItem) element).getTitle().equalsIgnoreCase(titleToRemove);
            }
            return false;
        });
        // връща true/false

        if (removed) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found inside this playlist.");
        }
    }
}
