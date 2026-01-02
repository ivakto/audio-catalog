package controller.menus;

import controller.InputProvider;
import entity.AudioItem;
import service.LibraryService;

import java.util.List;

public class RemoveMenu implements Menu{
    private final LibraryService libraryService;
    private final InputProvider inputProvider;

    public RemoveMenu(LibraryService libraryService,InputProvider inputProvider) {
        this.libraryService = libraryService;
        this.inputProvider = inputProvider;
    }

    @Override
    public void show() {
        System.out.println("\nREMOVE ITEM");
        String titleToRemove = inputProvider.readString("Enter the exact title of the item to remove: ");

        List<AudioItem> matches = libraryService.findMatches(titleToRemove);

        if (matches.isEmpty()) {
            System.out.println("\nNo item found with title: " + titleToRemove);
        }
        else if (matches.size() == 1) {
            AudioItem item = matches.getFirst();
            System.out.println("\nDeleting: " + item.getTitle() + " (" + item.getClass().getSimpleName() + ")");
            libraryService.removeById(item.getId());
        }
        else {
            System.out.println("\nFound " + matches.size() + " items matching '" + titleToRemove + "':");

            for (int i = 0; i < matches.size(); i++) {
                AudioItem item = matches.get(i);
                System.out.println("[" + (i + 1) + "] Type: " + item.getClass().getSimpleName() +
                        " | Author: " + item.getAuthor() +
                        " | Year: " + item.getReleaseYear());
            }

            int choice = inputProvider.readInt("\nEnter the NUMBER to delete: ");

            if (choice > 0 && choice <= matches.size()) {
                AudioItem itemToDelete = matches.get(choice - 1);
                libraryService.removeById(itemToDelete.getId());
            } else {
                System.out.println("Invalid number selected!");
            }
        }
    }
}
