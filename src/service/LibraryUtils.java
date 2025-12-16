package service;

import entity.AudioItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryUtils {

    public static <T extends AudioItem> List<T> filterByAuthor(List<T> items, String author) {
        List<T> result = new ArrayList<>();
        for (T item: items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                result.add(item);
            }
        }
        return  result;
    }

    public static <T extends AudioItem> List<T> filterByGenre(List<T> items, String genre) {
        List<T> result = new ArrayList<>();
        for (T item: items) {
            if (item.getGenre().equalsIgnoreCase(genre)) {
                result.add(item);
            }
        }
        return  result;
    }

    public static <T extends AudioItem> List<T> filterByYear(List<T> items, int year) {
        List<T> result = new ArrayList<>();
        for (T item: items) {
            if (item.getReleaseYear() == year) {
                result.add(item);
            }
        }
        return  result;
    }

    public static <T extends AudioItem> List<T> filterByCategory(List<T> items, String category) {
        List<T> result = new ArrayList<>();
        for (T item: items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return  result;
    }
}
