package service;

import entity.AudioItem;
import io.LibraryRepository;
import utils.Filter;
import utils.Search;
import utils.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LibraryService {
    private final List<AudioItem> library;
    private final LibraryRepository repository;


    public LibraryService() {
        this.repository = new LibraryRepository();
        this.library = this.repository.load();
    }

    public void addAudioItem(AudioItem item) {
        if (item != null) {
            library.add(item);
            repository.save(library);
            System.out.println("Successfully added: " + item.getTitle());
        } else {
            System.out.println("Error: Cannot add null item.");
        }
    }

    public List<AudioItem> findMatches(String title) {
        List<AudioItem> matches = new ArrayList<>();

        for (AudioItem item : library) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public void removeById(String id) {
        boolean removed = library.removeIf(item -> item.getId().equals(id));

        if (removed) {
            repository.save(library);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
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

    public <R> List<AudioItem> search(Function<? super AudioItem, R> getter, String query) {
        return Search.search(library, getter, query);
    }

    public List<AudioItem> searchFlexible(String title, String author, String genre, String category) {
        List<AudioItem> results = new ArrayList<>();

        for (AudioItem item : library) {
            boolean matches = title == null || containsIgnoreCase(item.getTitle(), title);

            if (author != null && !containsIgnoreCase(item.getAuthor(), author)) matches = false;
            if (genre != null && !containsIgnoreCase(item.getGenre(), genre)) matches = false;
            if (category != null && !containsIgnoreCase(item.getCategory(), category)) matches = false;

            if (matches) {
                results.add(item);
            }
        }
        return results;
    }

    private boolean containsIgnoreCase(String value, String search) {
        if (value == null) return false;
        return value.toLowerCase().contains(search.toLowerCase());
    }

    public <R extends Comparable<R>> List<AudioItem> sort(Function<? super AudioItem, R> getter, boolean isAscending) {
        return Sort.sort(library, getter, isAscending);
    }

    public <R> List<AudioItem> filter(Function<? super AudioItem, R> getter, R value) {
        return Filter.filter(library, getter, value);
    }

    public void saveLibrary() {
        repository.save(library);
    }
}