package service;

import entity.AudioItem;
import utils.Filter;
import utils.Search;
import utils.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LibraryService {
    private final List<AudioItem> library;

    public LibraryService() {
        this.library = new ArrayList<>();
    }

    public void addAudioItem(AudioItem item) {
        if (item != null) {
            library.add(item);
            System.out.println("Successfully added: " + item.getTitle());
        } else {
            System.out.println("Error: Cannot add null item.");
        }
    }

    public void removeAudioItem(String title) {
        boolean removed = library.removeIf(item -> item.getTitle().equalsIgnoreCase(title));

        if (removed) {
            System.out.println("Removed item(s) matching title: " + title);
        } else {
            System.out.println("Item not found with title: " + title);
        }
    }

    public List<AudioItem> getAllItems() {
        return new ArrayList<>(library);
    }

    public AudioItem findAudioItem(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }

        for (AudioItem item : library) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public <R> List<AudioItem> search(Function<AudioItem, R> getter, String query) {
        return Search.search(library, getter, query);
    }

    public <R extends Comparable<R>> List<AudioItem> sort(Function<AudioItem, R> getter, boolean isAscending) {
        return Sort.sort(library, getter, isAscending);
    }

    public <R> List<AudioItem> filter(Function<? super AudioItem, R> getter, R value) {
        return Filter.filter(library, getter, value);
    }
}