package controller.playlist;

import entity.AudioItem;
import entity.Playlist;

import java.util.Scanner;

public class PlaylistRemove {
    private final Scanner scanner;

    public PlaylistRemove(Scanner scanner) {
        this.scanner = scanner;
    }

    public void remove(Playlist playlist) {
        System.out.println("Enter title of item to remove: ");
        String titleToRemove = scanner.nextLine();

        boolean removed = playlist.getItemsList().removeIf(element -> ((AudioItem)element).getTitle().equalsIgnoreCase(titleToRemove));
        // връща true/false

        if (removed) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found inside this playlist.");
        }
    }
}
