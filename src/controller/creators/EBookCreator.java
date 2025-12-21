package controller.creators;

import controller.InputProvider;
import entity.AudioItem;
import entity.EBook;

public class EBookCreator implements ItemCreator{

    @Override
    public EBook create(InputProvider input) {
        System.out.println("\nADD NEW AUDIO BOOK");

        String title = input.readString("Title: ");
        String author = input.readString("Author: ");
        String genre = input.readString("Genre: ");
        int year = input.readInt("Release Year: ");
        int duration = input.readInt("Total Duration (sec): ");

        int chapters = input.readInt("Number of Chapters: ");
        String language = input.readString("Language: ");

        return new EBook(title, author, genre, duration, "EBook", year, chapters, language);
    }
}
