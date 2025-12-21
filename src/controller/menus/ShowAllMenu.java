package controller.menus;

import entity.AudioItem;
import service.LibraryService;
import utils.ConsolePrinter;

import java.util.List;

public class ShowAllMenu {
    private final LibraryService libraryService;

    public ShowAllMenu(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void showAll() {
        List<AudioItem> all = libraryService.getAllItems();

        ConsolePrinter.printList(all, "ALL ITEMS");
    }
}
