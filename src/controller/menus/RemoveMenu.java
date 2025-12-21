package controller.menus;

import service.LibraryService;

import java.util.Scanner;

public class RemoveMenu {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public RemoveMenu(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("\nREMOVE ITEM");
        System.out.print("Enter the exact title of the item to remove: ");
        String title = scanner.nextLine();

        libraryService.removeAudioItem(title);
    }
}
