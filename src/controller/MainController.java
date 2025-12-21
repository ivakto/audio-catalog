package controller;

import controller.menus.*;
import service.LibraryService;

import java.util.Scanner;

public class MainController {

    private final AddMenu addMenu;
    private final RemoveMenu removeMenu;
    private final ShowAllMenu showMenu;
    private final SearchMenu searchMenu;
    private final SortMenu sortMenu;
    private final FilterMenu filterMenu;
    private final Scanner scanner;

    public MainController() {
        this.scanner = new Scanner(System.in);
        InputProvider inputProvider = new InputProvider(scanner);
        LibraryService libraryService = new LibraryService();

        this.addMenu = new AddMenu(libraryService, inputProvider, scanner);
        this.removeMenu = new RemoveMenu(libraryService, scanner);
        this.showMenu = new ShowAllMenu(libraryService);

        this.searchMenu = new SearchMenu(libraryService, scanner);
        this.sortMenu = new SortMenu(libraryService, scanner);
        this.filterMenu = new FilterMenu(libraryService, inputProvider);

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
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
