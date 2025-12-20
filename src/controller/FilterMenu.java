package controller;

import entity.*;
import utils.Validator;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FilterMenu {

    private final LibraryController libraryService;
    private final Scanner scanner;

    public FilterMenu(LibraryController libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("MENU FILTER");
        System.out.println("Options:");
        System.out.println("1. By Title");
        System.out.println("2. By Genre");
        System.out.println("3. By Duration");
        System.out.println("4. By Author");
        System.out.println("6. By Release Year");

        System.out.println("Choose option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> processStringFilter("Title: ", AudioItem::getTitle);
            case "2" -> processStringFilter("Genre: ", AudioItem::getGenre);
            case "3" -> processIntFilter("Duration (sec): ", AudioItem::getDurationSec);
            case "4" -> processStringFilter("Author: ", AudioItem::getAuthor);
            case "5" -> processIntFilter("Release Year: ", AudioItem::getReleaseYear);

            default -> System.out.println("Invalid option!");
        }

    }

    private void processStringFilter(String prompt, Function<AudioItem, String> getter) {
        System.out.print("Enter " + prompt);
        String value = scanner.nextLine();

        List<AudioItem> results = libraryService.filter(getter, value);
        printResults(results);
    }

    private void processIntFilter(String prompt, Function<AudioItem, Integer> getter) {
        System.out.print("Enter " + prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine());
            List<AudioItem> results = libraryService.filter(getter, value);
            printResults(results);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number!");
        }
    }

    private void printResults(List<AudioItem> items) {
        if (items.isEmpty()) {
            System.out.println("   (No results found)");
        } else {
            System.out.println("FILTER RESULTS:");
            for (AudioItem item : items) {
                System.out.println(" -> " + item.getTitle() + " | " + item.getAuthor() + " (" + item.getReleaseYear() + ")");
            }
        }
    }


}
