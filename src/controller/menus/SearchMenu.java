package controller.menus;


import entity.AudioItem;
import service.LibraryService;
import utils.ConsolePrinter;
import utils.Validator;

import java.util.List;
import java.util.Scanner;

public class SearchMenu {
    private final LibraryService service;
    private final Scanner scanner;

    public SearchMenu(LibraryService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("\nMENU SEARCH");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By Genre");
        System.out.println("4. By Category");
        System.out.println("0. Back");
        System.out.print("Choose criteria: ");

        String choice = scanner.nextLine();
        if (choice.equals("0")) return;

        System.out.print("Enter text to search: ");
        String query = scanner.nextLine();

        try {
            Validator.validateString(query, "Search query");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        List<AudioItem> results = switch (choice) {
            case "1" -> service.search(AudioItem::getTitle, query);
            case "2" -> service.search(AudioItem::getAuthor, query);
            case "3" -> service.search(AudioItem::getGenre, query);
            case "4" -> service.search(AudioItem::getCategory, query);
            default -> {
                System.out.println("Invalid criteria!");
                yield List.of(); // Връща празен списък при грешка
            }
        };

        ConsolePrinter.printList(results, "SEARCH RESULTS");
    }
}
