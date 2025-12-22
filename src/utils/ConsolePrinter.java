package utils;

import entity.AudioItem;
import java.util.List;

public class ConsolePrinter {

    public static void printList(List<AudioItem> items, String header) {
        if (items.isEmpty()) {
            System.out.println("\n(No items found)");
            return;
        }

        System.out.println("\n" + header.toUpperCase());

        System.out.printf("%-4s %-25s %-16s %-6s %-11s %s%n", "NUM", "TITLE", "AUTHOR", "YEAR", "GENRE", "TIME");

        int index = 1;
        for (AudioItem item : items) {
            System.out.printf("%-4s %-25s %-16s %-6d %-11s %d sec%n",
                    index++ + ".",
                    truncate(item.getTitle(), 23),
                    truncate(item.getAuthor(), 14),
                    item.getReleaseYear(),
                    truncate(item.getGenre(), 9),
                    item.getDurationSec()
            );
        }
        System.out.println(); // Празен ред за въздух най-долу
    }

    private static String truncate(String text, int maxLength) {
        if (text == null) return "";
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 2) + "..";
    }
}


