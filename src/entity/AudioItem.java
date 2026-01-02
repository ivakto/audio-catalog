package entity;

import utils.Validator;

import java.util.UUID;

public abstract class AudioItem {
    private String title;
    private String id;
    private String genre;
    private int durationSec;
    private String category;
    private String author;
    private int releaseYear;

    public AudioItem(String title, String author, String genre, int durationSec, String category, int releaseYear) {

        this.title = Validator.validateString(title, "Title");
        this.id = UUID.randomUUID().toString();
        this.genre = Validator.validateString(genre, "Genre");
        this.durationSec = Validator.validateDuration(durationSec, "Duration");
        this.category = Validator.validateString(category, "Category");
        this.author = Validator.validateString(author, "Author");
        this.releaseYear = Validator.validateYear(releaseYear, "Release year");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(int durationSec) {
        this.durationSec = durationSec;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}
