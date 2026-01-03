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

    public List<AudioItem> searchFlexible(String title, String author, String genre, String category) {
        List<AudioItem> results = new ArrayList<>(library);

        if (title != null && !title.isEmpty()) {
            results = Search.search(results, AudioItem::getTitle, title);
        }

        if (author != null && !author.isEmpty()) {
            results = Search.search(results, AudioItem::getAuthor, author);
        }

        if (genre != null && !genre.isEmpty()) {
            results = Search.search(results, AudioItem::getGenre, genre);
        }

        if (category != null && !category.isEmpty()) {
            results = Search.search(results, AudioItem::getCategory, category);
        }
        return results;
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