package controller;

import entity.*;
import service.LibraryService;

import java.util.Scanner;

public class LibraryController {

    private final Scanner scanner;
    private final LibraryService libraryService;

    public LibraryController(Scanner scanner, LibraryService libraryService) {
        this.scanner = scanner;
        this.libraryService = libraryService;
    }

    public void menu () {
        boolean back = false;

        while (!back) {
            System.out.println("\nLIBRARY MENU");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Show all");
            System.out.println("4. Search");
            System.out.println("5. Filter");
            System.out.println("6. Sort");
            System.out.println("0. Back");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addMenu();
                case 2 -> removeItem();
                case 3 -> libraryService.showAll();
                case 4 -> searchMenu();
                case 5 -> filterMenu();
                case 6 -> sortMenu();
                case 0 -> back = true;
            }
        }
    }

    private void addMenu() {
        System.out.println("1. Song");
        System.out.println("2. Podcast");
        System.out.println("3. EBook");
        System.out.println("4. Music album");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> libraryService.addSong(scanner);
            case 2 -> libraryService.addPodcast(scanner);
            case 3 -> libraryService.addEBook(scanner);
            case 4 -> libraryService.addMusicAlbum(scanner);
        }
    }

    private void removeItem() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        libraryService.removeByTitle(title);
    }

    private void searchMenu() {
        System.out.print("Search by title: ");
        String term = scanner.nextLine();
        libraryService.searchByTitle(term);
    }

    private void filterMenu() {
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        libraryService.filterByGenre(genre);
    }

    private void sortMenu() {
        libraryService.sortByTitle();
    }

}


