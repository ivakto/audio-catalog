package controller.playlist;

import controller.InputProvider;
import entity.AudioItem;
import entity.MusicAlbum;
import entity.Playlist;
import entity.PlaylistInsertable;
import service.LibraryService;

public class PlaylistAdd {
    private final LibraryService service;
    private final InputProvider inputProvider;

    public PlaylistAdd(LibraryService service, InputProvider inputProvider) {
        this.service = service;
        this.inputProvider = inputProvider;
    }

    public void add(Playlist playlist) {
        String itemTitle = inputProvider.readString("Enter title of the item to add: ");

        AudioItem item = service.findAudioItem(itemTitle);

        if (item == null) {
            System.out.println("Item not found in library!");
            return;
        }

        if (item instanceof MusicAlbum) {
            System.out.println("Error: You cannot add a whole Music Album to a playlist!");
            return;
        }

        if (item instanceof PlaylistInsertable) {
            playlist.getItemsList().add((PlaylistInsertable) item);
            service.saveLibrary();
            System.out.println("Successfully added '" + item.getTitle() + "' to playlist '" + playlist.getTitle() + "'.");
        } else {
            System.out.println("Error: This item cannot be added to a playlist.");
        }
    }
}
