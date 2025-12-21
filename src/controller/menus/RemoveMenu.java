package controller.menus;

import controller.InputProvider;
import service.LibraryService;

public class RemoveMenu {
    private final LibraryService libraryService;
    private final InputProvider inputProvider;

    public RemoveMenu(LibraryService libraryService,InputProvider inputProvider) {
        this.libraryService = libraryService;
        this.inputProvider = inputProvider;
    }

    public void show() {
        System.out.println("\nREMOVE ITEM");
        String title = inputProvider.readString("Enter the exact title of the item to remove: ");
        libraryService.removeAudioItem(title);
    }
}
