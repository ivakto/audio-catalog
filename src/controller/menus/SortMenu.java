package controller.menus;

import entity.AudioItem;
import service.LibraryService;
import utils.ConsolePrinter;

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
        System.out.println("1. By Title (A-Z)");
        System.out.println("2. By Author (A-Z)");
        System.out.println("3. By Year (Oldest First)");
        System.out.println("4. By Year (Newest First)");
        System.out.println("5. By Duration");
        System.out.println("0. Back");
        System.out.print("Choose sort option: ");

        String choice = scanner.nextLine();
        if (choice.equals("0")) return;

        List<AudioItem> results = switch (choice) {
            case "1" -> service.sort(AudioItem::getTitle, true);
            case "2" -> service.sort(AudioItem::getAuthor, true);
            case "3" -> service.sort(AudioItem::getReleaseYear, true);
            case "4" -> service.sort(AudioItem::getReleaseYear, false);
            case "5" -> service.sort(AudioItem::getDurationSec, true);
            default -> {
                System.out.println("Invalid sort option!");
                yield List.of();// най-бърз начин за създаване на празен list
            }
        };

        ConsolePrinter.printList(results, "SORTED LIST");
    }

}
