package controller.menus;

import entity.AudioItem;
import service.LibraryService;
import utils.ConsolePrinter;

import java.util.List;

public class ShowMenu implements Menu{
    private final LibraryService libraryService;

    public ShowMenu(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void show() {
        List<AudioItem> all = libraryService.getAllItems();

        ConsolePrinter.printList(all, "ALL ITEMS");
    }
}
