import entity.*;
import io.LibraryRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Писане
        List<AudioItem> items = new ArrayList<>();

        Song song = new Song("Song", "Iva", "classic", 1200, "kkk", 2004, 8, "LaLaLa");
        Podcast podcast = new Podcast("Java Daily", "John Doe", "Tech", 1200, "Education", 2024, 55, "All about Java");
        EBook ebook = new EBook("Harry Potter", "J.K. Rowling", "Fantasy", 30000, "Audiobook", 2001, 17, "English");

        ArrayList<Song> albumSongs = new ArrayList<>();
        albumSongs.add(song);
        MusicAlbum musicAlbum = new MusicAlbum("After Hours", "The Weeknd", "Pop", 3200, "Album", 2020, "XO / Republic", albumSongs);
        
        items.add(song);
        items.add(podcast);
        items.add(ebook);
        items.add(musicAlbum);

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
