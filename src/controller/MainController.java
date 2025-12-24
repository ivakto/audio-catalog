package controller;

import controller.menus.*;
import controller.playlist.PlaylistAdd;
import controller.playlist.PlaylistRemove;
import controller.playlist.PlaylistView;
import service.LibraryService;

import java.util.Scanner;

public class MainController {

    private final AddMenu addMenu;
    private final RemoveMenu removeMenu;
    private final ShowMenu showMenu;
    private final SearchMenu searchMenu;
    private final SortMenu sortMenu;
    private final FilterMenu filterMenu;
    private final PlaylistMenu playlistMenu;
    private final Scanner scanner;
    private final LibraryService libraryService;

    public MainController() {
        this.scanner = new Scanner(System.in);
        InputProvider inputProvider = new InputProvider(scanner);
        this.libraryService = new LibraryService();

        PlaylistAdd playlistAdder = new PlaylistAdd(libraryService, inputProvider);
        PlaylistRemove playlistRemover = new PlaylistRemove(inputProvider);
        PlaylistView playlistViewer = new PlaylistView();

        this.addMenu = new AddMenu(libraryService, inputProvider, scanner);
        this.removeMenu = new RemoveMenu(libraryService, inputProvider);
        this.showMenu = new ShowMenu(libraryService);
        this.searchMenu = new SearchMenu(libraryService, scanner, inputProvider);
        this.sortMenu = new SortMenu(libraryService, scanner, inputProvider);
        this.filterMenu = new FilterMenu(libraryService, inputProvider);

        this.playlistMenu = new PlaylistMenu(libraryService, scanner, inputProvider,
                playlistAdder, playlistRemover, playlistViewer);
    }

    public void run() {
        boolean running = true;

        while (running) {
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

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addMenu.show();
                case "2" -> removeMenu.show();
                case "3" -> showMenu.showAll();
                case "4" -> searchMenu.show();
                case "5" -> filterMenu.show();
                case "6" -> sortMenu.show();
                case "7" -> playlistMenu.show();
                case "0" -> {
                    System.out.println("Goodbye!");
                    libraryService.saveLibrary(); // <--- ВАЖНО: Този ред липсваше!
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}