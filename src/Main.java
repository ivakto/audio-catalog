import entity.AudioItem;
import entity.Song;
import service.io.LibraryRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Писане
        List<AudioItem> items = new ArrayList<>();
        Song song = new Song("Song", "Iva", "classic", 1200, "kkk", 2004, 8, "LaLaLa");
        items.add(song);
        LibraryRepository.save(items);

        // Четене
        List<AudioItem> loadedItems = LibraryRepository.load();
        System.out.println("Заредени са " + loadedItems.size() + " елемента.");

        for (AudioItem item : loadedItems) {
            System.out.println("\nЗаредено: " + item.getTitle() + " | Автор: " + item.getAuthor());
            System.out.println("ID: " + item.getId());
        }
    }
}
