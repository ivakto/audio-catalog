package controller.menus;

import controller.InputProvider;
import controller.creators.*;
import entity.AudioItem;
import service.LibraryService;

import java.util.Scanner;

public class AddMenu implements Menu{

    private final LibraryService libraryService;
    private final InputProvider inputProvider;
    private final Scanner scanner;

    public AddMenu(LibraryService libraryService, InputProvider inputProvider, Scanner scanner) {
        this.libraryService = libraryService;
        this.inputProvider = inputProvider;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("\nADD NEW ITEM");
        System.out.println("1. Song");
        System.out.println("2. Podcast");
        System.out.println("3. Audio Book");
        System.out.println("4. Music Album");
        System.out.println("5. Playlist");
        System.out.println("0. Back");
        System.out.print("Choose type: ");

        String type = scanner.nextLine();
        ItemCreator creator = null;

        switch (type) {
            case "1" -> creator = new SongCreator();
            case "2" -> creator = new PodcastCreator();
            case "3" -> creator = new EBookCreator();
            case "4" -> creator = new MusicAlbumCreator();
            case "5" -> creator = new PlaylistCreator();
            case "0" -> { return; }
            default -> System.out.println("Invalid type.");
        }

        if (creator != null) {
            try {
                AudioItem newItem = creator.create(inputProvider);
                libraryService.addAudioItem(newItem);
            } catch (Exception e) {
                System.out.println("Error creating item: " + e.getMessage());
            }
        }
    }
}
