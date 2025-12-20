package entity;

import utils.Validator;

public class EBook extends AudioItem implements PlaylistInsertable{
    private int numberOfChapters;
    private String language;

    public EBook(String title, String author, String genre, int durationSec, String category, int releaseYear, int numberOfChapters, String language) {
        super(title, author, genre, durationSec, category, releaseYear);

        this.numberOfChapters = Validator.validatePositive(numberOfChapters, "Chapters");
        this.language = Validator.validateString(language, "Language");
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
