package entity;

public class EBook extends AudioItem implements PlaylistInsertable{
    private int numberOfChapters;
    private String language;

    public EBook(String title, String author, String genre, int durationSec, String category, int releaseYear, int numberOfChapters, String language) {
        super(title, author, genre, durationSec, category, releaseYear);
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
