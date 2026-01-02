package controller.playlist;

import controller.InputProvider;
import entity.AudioItem;
import entity.Playlist;
import entity.PlaylistInsertable;
import service.LibraryService;

public class PlaylistRemove {

    private final LibraryService service;
    private final InputProvider inputProvider;


    public PlaylistRemove(LibraryService service, InputProvider inputProvider) {
        this.service = service;
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

        if (removed) {
            service.saveLibrary();
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found inside this playlist.");
        }
    }
}