package controller.creators;

import controller.InputProvider;
import entity.Song;

public class SongCreator implements ItemCreator{


    @Override
    public Song create(InputProvider input) {
        System.out.println("\nADD NEW SONG");

        String title = input.readString("Title: ");
        String author = input.readString("Artist: ");
        String genre = input.readString("Genre: ");
        int year = input.readReleaseYear("Release Year: ");
        int duration = input.readInt("Duration (sec): ");

        String lyrics = input.readString("Lyrics (short excerpt): ");
        int rating = input.readRating("Rating (0-10): ");

        return new Song(title, author, genre, duration, "Song", year, rating, lyrics);
    }
}
