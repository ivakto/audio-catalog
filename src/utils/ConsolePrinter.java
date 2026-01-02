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
            String formattedTime = formatDuration(item.getDurationSec());
            System.out.printf("%-4s %-25s %-16s %-6d %-11s %s%n",
                    index++ + ".",
                    truncate(item.getTitle(), 23),
                    truncate(item.getAuthor(), 14),
                    item.getReleaseYear(),
                    truncate(item.getGenre(), 9),
                    formattedTime
            );
        }
        System.out.println();
    }

    private static String truncate(String text, int maxLength) {
        if (text == null) return "";
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 2) + "..";
    }

    private static String formatDuration(int totalSeconds) {

        if (totalSeconds < 3600) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            return String.format("%d:%02d min", minutes, seconds);
        } else {
            int hours = totalSeconds / 3600;
            int remainingMinutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            return String.format("%d:%02d:%02d h", hours, remainingMinutes, seconds);
        }
    }

}


