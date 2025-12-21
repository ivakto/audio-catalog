package utils;

import entity.AudioItem;
import java.util.List;

public class ConsolePrinter {
    public static void printList(List<AudioItem> items, String header) {
        if (items.isEmpty()) {
            System.out.println("(Empty list)");
        } else {
            System.out.println("\n--- " + header + " ---");
            for (AudioItem item : items) {
                System.out.println(" -> " + item.getTitle() + " - " + item.getAuthor() + " (" + item.getCategory() + ")");
            }
        }
    }
}
