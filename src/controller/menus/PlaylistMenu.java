package controller.menus;

import controller.InputProvider;
import controller.playlist.PlaylistAdd;
import controller.playlist.PlaylistRemove;
import controller.playlist.PlaylistView;
import entity.AudioItem;
import entity.Playlist;
import service.LibraryService;

import java.util.Scanner;

public class PlaylistMenu {
    private final LibraryService libraryService;
    private final Scanner scanner;
    private final InputProvider inputProvider;

    private final PlaylistAdd adder;
    private final PlaylistRemove remover;
    private final PlaylistView viewer;

    public PlaylistMenu(LibraryService libraryService, Scanner scanner, InputProvider inputProvider, PlaylistAdd adder, PlaylistRemove remover, PlaylistView viewer) {
        this.libraryService = libraryService;
        this.scanner = scanner;
        this.inputProvider = inputProvider;
        this.adder = adder;
        this.remover = remover;
        this.viewer = viewer;
    }

    public void show() {
        while (true) {
            System.out.println("\nPLAYLIST MENU");
            System.out.println("1. Add new element in playlist.");
            System.out.println("2. Delete element in playlist.");
            System.out.println("3. Show playlist content");
            System.out.println("0. Back");

            System.out.println("Select option: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                return;
            }

            Playlist currentPlaylist = findPlaylistByTitle();

            if (currentPlaylist == null) {
                continue;
            }

            switch (choice) {
                case "1" -> adder.add(currentPlaylist);
                case "2" -> remover.remove(currentPlaylist);
                case "3" -> viewer.print(currentPlaylist);

                default -> System.out.println("Invalid option!");
            }
        }
    }

    private Playlist findPlaylistByTitle() {
        String playlistTitle = inputProvider.readString("Enter playlist title to work with: ");

        AudioItem item = libraryService.findAudioItem(playlistTitle);

        if (item == null) {
            System.out.println("Playlist not found!");
            return null;
        }

        if (item instanceof Playlist) {
            return (Playlist) item;
        } else {
            System.out.println("Error: '" + playlistTitle + "' is not a playlist (it might be a song, album, etc.)!");
            return null;
        }
    }
}
