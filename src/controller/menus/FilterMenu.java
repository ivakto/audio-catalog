package controller.menus;

import controller.InputProvider;
import entity.*;
import service.LibraryService;
import utils.ConsolePrinter;

import java.util.List;
import java.util.function.Function;

public class FilterMenu implements Menu{

    private final LibraryService libraryService;
    private final InputProvider inputProvider;

    public FilterMenu(LibraryService libraryService, InputProvider inputProvider) {
        this.libraryService = libraryService;
        this.inputProvider = inputProvider;
    }

    @Override
    public void show() {
        System.out.println("\nMENU FILTER");
        System.out.println("1. By Title");
        System.out.println("2. By Genre");
        System.out.println("3. By Duration");
        System.out.println("4. By Author");
        System.out.println("5. By Release Year");
        System.out.println("0. Back");

        String choice = inputProvider.readString("Choose option: ");

        switch (choice) {
            case "1" -> processFilter(AudioItem::getTitle, inputProvider.readString("Enter Title: "));
            case "2" -> processFilter(AudioItem::getGenre, inputProvider.readString("Enter Genre: "));
            case "3" -> processFilter(AudioItem::getDurationSec, inputProvider.readInt("Enter Duration: "));
            case "4" -> processFilter(AudioItem::getAuthor, inputProvider.readString("Enter Author: "));
            case "5" -> processFilter(AudioItem::getReleaseYear, inputProvider.readInt("Enter Year: "));
            case "0" -> {
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private <T> void processFilter(Function<AudioItem, T> getter, T value) {
        List<AudioItem> results = libraryService.filter(getter, value);
        ConsolePrinter.printList(results, "FILTER RESULTS");
    }

}
