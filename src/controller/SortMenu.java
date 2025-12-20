package controller;

import entity.AudioItem;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class SortMenu {
    private final LibraryService service;
    private final Scanner scanner;

    public SortMenu(LibraryService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("\nSORT MENU");
        System.out.println("1. By Title (A -> Z)");
        System.out.println("2. By Author (A -> Z)");
        System.out.println("3. By Year (Oldest -> Newest)");
        System.out.println("4. By Year (Newest -> Oldest)");
        System.out.println("5. By Duration (Shortest -> Longest)");
        System.out.print("Choose sort option: ");

        String choice = scanner.nextLine();
        List<AudioItem> results;

        switch (choice) {
            case "1" -> results = service.sort(AudioItem::getTitle, true);
            case "2" -> results = service.sort(AudioItem::getAuthor, true);
            case "3" -> results = service.sort(AudioItem::getReleaseYear, true);
            case "4" -> results = service.sort(AudioItem::getReleaseYear, false);
            case "5" -> results = service.sort(AudioItem::getDurationSec, true);

            default -> {
                System.out.println("Invalid sort option!");
                return;
            }
        }

        printList(results);
    }

    private void printList(List<AudioItem> items) {
        if (items.isEmpty()) {
            System.out.println("   (List is empty)");
        } else {
            System.out.println("\nRESULTS:");
            for (AudioItem item : items) {
                // Най-просто принтиране: Заглавие - Автор (Година)
                System.out.println("   -> " + item.getTitle() + " - " + item.getAuthor() + " (" + item.getReleaseYear() + ")");
            }
        }
    }
}
