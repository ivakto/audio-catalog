package controller.menus;


import controller.InputProvider;
import entity.AudioItem;
import service.LibraryService;
import utils.ConsolePrinter;
import utils.Validator;

import java.util.List;
import java.util.Scanner;

public class SearchMenu implements Menu{
    private final LibraryService service;
    private final Scanner scanner;
    private final InputProvider inputProvider;

    public SearchMenu(LibraryService service, Scanner scanner, InputProvider inputProvider) {
        this.service = service;
        this.scanner = scanner;
        this.inputProvider = inputProvider;
    }

    @Override
    public void show() {
        while (true) {
            System.out.println("\nMENU SEARCH");
            System.out.println("1. By Title");
            System.out.println("2. By Author");
            System.out.println("3. By Genre");
            System.out.println("4. By Category");
            System.out.println("0. Back");
            System.out.print("\nYour choice: ");

            String input = scanner.nextLine().trim();
            if (input.equals("0")) return;

            String[] choices = input.split(",");

            for (String choice : choices) {
                if (choice.trim().equals("0")) return;
            }

            String searchTitle = null;
            String searchAuthor = null;
            String searchGenre = null;
            String searchCategory = null;

            boolean validSelection = false;

            for (String choice : choices) {
                String c = choice.trim();

                switch (c) {
                    case "1" -> {
                        searchTitle = inputProvider.readString("Enter Title part: ");
                        validSelection = true;
                    }
                    case "2" -> {
                        searchAuthor = inputProvider.readString("Enter Author part: ");
                        validSelection = true;
                    }
                    case "3" -> {
                        searchGenre = inputProvider.readString("Enter Genre part: ");
                        validSelection = true;
                    }
                    case "4" -> {
                        searchCategory = inputProvider.readString("Enter Category part: ");
                        validSelection = true;
                    }
                }
            }

            if (!validSelection) {
                System.out.println("No valid criteria selected.");
                continue;
            }

            System.out.println("\nSearching...");
            List<AudioItem> results = service.searchFlexible(searchTitle, searchAuthor, searchGenre, searchCategory);

            ConsolePrinter.printList(results, "SEARCH RESULTS");
        }

    }
}
