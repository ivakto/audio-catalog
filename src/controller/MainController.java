package controller;

import controller.menus.*;
import controller.playlist.PlaylistAdd;
import controller.playlist.PlaylistRemove;
import controller.playlist.PlaylistView;
import service.LibraryService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainController {

    private final Scanner scanner;
    private final LibraryService libraryService;
    private final Map<String, Menu> menus = new HashMap<>();

    public MainController() {
        this.scanner = new Scanner(System.in);
        InputProvider inputProvider = new InputProvider(scanner);
        this.libraryService = new LibraryService();

        PlaylistAdd playlistAdder = new PlaylistAdd(libraryService, inputProvider);
        PlaylistRemove playlistRemover = new PlaylistRemove(libraryService, inputProvider);
        PlaylistView playlistViewer = new PlaylistView();

        menus.put("1", new AddMenu(libraryService, inputProvider, scanner));
        menus.put("2", new RemoveMenu(libraryService, inputProvider));
        menus.put("3", new ShowMenu(libraryService));
        menus.put("4", new SearchMenu(libraryService, scanner, inputProvider));
        menus.put("5", new FilterMenu(libraryService, inputProvider));
        menus.put("6", new SortMenu(libraryService, scanner, inputProvider));
        menus.put("7", new PlaylistMenu(libraryService, scanner, inputProvider, playlistAdder, playlistRemover, playlistViewer));
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Saving library...");
                libraryService.saveLibrary();
                System.out.println("Goodbye!");
                running = false;
                continue;
            }

            Menu selectedMenu = menus.get(choice);

            if (selectedMenu != null) {
                selectedMenu.show();
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\nAUDIO CATALOG ORGANIZER");
        System.out.println("1. Add New Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Show All Items");
        System.out.println("4. Search...");
        System.out.println("5. Filter...");
        System.out.println("6. Sort...");
        System.out.println("7. Manage Playlists");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }
}