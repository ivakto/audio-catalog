package controller.creators;

import controller.InputProvider;
import entity.Podcast;

public class PodcastCreator implements ItemCreator{

    @Override
    public Podcast create(InputProvider input) {
        System.out.println("\nADD NEW PODCAST");

        String title = input.readString("Podcast Title: ");
        String author = input.readString("Author: ");
        String genre = input.readString("Topic/Genre: ");
        int year = input.readReleaseYear("Year: ");
        int duration = input.readInt("Duration (sec): ");

        int episodes = input.readInt("Number of Episodes: ");
        String description = input.readString("Description: ");

        return new Podcast(title, author, genre, duration, "Podcast", year, episodes, description);
    }
}
