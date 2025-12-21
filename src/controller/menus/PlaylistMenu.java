package controller.menus;

import controller.InputProvider;
import service.LibraryService;

import java.util.Scanner;

public class PlaylistMenu {
    private final LibraryService libraryService;
    private final Scanner scanner;
    private final InputProvider inputProvider;

    public PlaylistMenu(LibraryService libraryService, Scanner scanner, InputProvider inputProvider) {
        this.libraryService = libraryService;
        this.scanner = scanner;
        this.inputProvider = inputProvider;
    }

    public void show() {
        while (true) {
            System.out.println("PLAYLIST MENU");
            System.out.println("1. Add new element in playlist.");
            System.out.println("2. Delete element in playlist.");
            System.out.println("3. Show playlist content");
            System.out.println("0. Back");

            System.out.println("Select option: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                return;
            }

            switch (choice) {
                case "1" ->
                case "2" ->
                case "3" ->
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
