package controller.creators;

import controller.InputProvider;
import entity.AudioItem;
import entity.Playlist;
import entity.PlaylistInsertable;

import java.util.ArrayList;

public class PlaylistCreator implements  ItemCreator{

    @Override
    public Playlist create(InputProvider input) {
        System.out.println("\nADD NEW PLAYLIST");

        String title = input.readString("Playlist title: ");
        String author = input.readString("Author: ");
        String genre = input.readString("Genre: ");
        int year = input.readReleaseYear("Release Year: ");
        int duration = input.readInt("Total Duration (sec): ");

        String answer = input.readString("Is it public? (yes/no): ");
        boolean isPublic = answer.equalsIgnoreCase("yes");

        ArrayList<PlaylistInsertable> playlist = new ArrayList<>();

        return new Playlist(title, author, genre, duration, "Playlist", year, isPublic, playlist);
    }
}
