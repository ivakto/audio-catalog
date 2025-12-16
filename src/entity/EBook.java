package entity;

public class EBook extends AudioItem implements PlaylistInsertable{
    private int numberOfChapters;
    private String eBookTitle;
    private String language;

    public EBook(String genre, int durationSec, String category, String author, int releaseYear, int numberOfChapters, String eBookTitle, String language) {
        super(genre, durationSec, category, author, releaseYear);
        if (numberOfChapters < 0) {
            throw new IllegalArgumentException("Number of chapters cannot be negative!");
        }
        if (eBookTitle == null || eBookTitle.isEmpty()) {
            throw new IllegalArgumentException("EBook cannot be null!");
        }
        if (language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Language cannot be null!");
        }

        this.numberOfChapters = numberOfChapters;
        this.eBookTitle = eBookTitle;
        this.language = language;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }

    public String geteBookTitle() {
        return eBookTitle;
    }

    public void seteBookTitle(String eBookTitle) {
        this.eBookTitle = eBookTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
