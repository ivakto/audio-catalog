package entity;

import service.utils.Validator;

public class EBook extends AudioItem implements PlaylistInsertable{
    private int numberOfChapters;
    private String language;

    public EBook(String title, String author, String genre, int durationSec, String category, int releaseYear, int numberOfChapters, String language) {
        super(title, author, genre, durationSec, category, releaseYear);

        Validator.validatePositive(numberOfChapters, "Chapters");
        Validator.validateString(language, "Language");

        this.numberOfChapters = numberOfChapters;
        this.language = language;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
