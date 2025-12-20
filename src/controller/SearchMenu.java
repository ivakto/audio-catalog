package controller;

import entity.AudioItem;
import service.LibraryService;
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
        System.out.println("MENU SEARCH");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By Genre");
        System.out.println("4. By Category");
        System.out.println("5. By Year");
        System.out.println("6. By Duration");
        System.out.print("Choose criteria: ");

        String choice = scanner.nextLine();

        System.out.print("Enter text to search: ");
        String query = scanner.nextLine();


        try {
            Validator.validateString(query, "Search query");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        List<AudioItem> results;

        switch (choice) {
            case "1" -> results = service.search(AudioItem::getTitle, query);
            case "2" -> results = service.search(AudioItem::getAuthor, query);
            case "3" -> results = service.search(AudioItem::getGenre, query);
            case "4" -> results = service.search(AudioItem::getCategory, query);
            case "5" -> results = service.search(AudioItem::getReleaseYear, query);
            case "6" -> results = service.search(AudioItem::getDurationSec, query);
            default -> {
                System.out.println("Invalid criteria!");
                return;
            }
        }

        printList(results);
    }

    private void printList(List<AudioItem> items) {
        if (items.isEmpty()) {
            System.out.println("   (No results found)");
        } else {
            System.out.println("Found " + items.size() + " items:");
            items.forEach(item -> System.out.println("   -> " + item.getTitle() + " - " + item.getAuthor()));
        }
    }
}
