package controller.creators;

import controller.InputProvider;
import entity.AudioItem;
import entity.MusicAlbum;
import entity.Song;

import java.util.ArrayList;

public class MusicAlbumCreator implements ItemCreator{

    @Override
    public MusicAlbum create(InputProvider input) {
        System.out.println("\nADD NEW MUSIC ALBUM");

        String title = input.readString("Album Title: ");
        String author = input.readString("Artist: ");
        String genre = input.readString("Genre: ");
        int year = input.readReleaseYear("Release Year: ");

        String label = input.readString("Record Label: ");
        ArrayList<Song> songs = new ArrayList<>();

        System.out.println("\nADD SONGS TO ALBUM ");
        int songsCount = input.readInt("How many songs to add now? (0 for none): ");

        SongCreator songCreator = new SongCreator();

        int totalDuration = 0;

        for (int i = 0; i < songsCount; i++) {
            Song newSong = songCreator.create(input);
            songs.add(newSong);
            totalDuration += newSong.getDurationSec();
        }

        System.out.println("Calculated Total Duration: " + totalDuration + " seconds.");

        return new MusicAlbum(title, author, genre, totalDuration, "MusicAlbum", year, label, songs);
    }
}
