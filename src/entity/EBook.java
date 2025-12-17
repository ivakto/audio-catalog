package entity;

public class EBook extends AudioItem implements PlaylistInsertable{
    private int numberOfChapters;
    private String language;

    public EBook(String genre, int durationSec, String category, String title, String author, int releaseYear, int numberOfChapters, String language) {
        super(genre, durationSec, category, author, releaseYear, title);
        if (numberOfChapters < 0) {
            throw new IllegalArgumentException("Number of chapters cannot be negative!");
        }
        if (language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Language cannot be null!");
        }

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
