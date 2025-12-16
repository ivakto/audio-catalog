package entity;

import java.util.UUID;

public abstract class AudioItem {
    private String id;
    private String genre;
    private int durationSec;
    private String category;
    private String author;
    private int releaseYear;

    public AudioItem(String genre, int durationSec, String category, String author, int releaseYear) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty!");
        };
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty!");
        };
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty!");
        };
        if (durationSec < 0) {
            throw new IllegalArgumentException("Duration cannot be negative!");
        };
        if (releaseYear < 0) {
            throw new IllegalArgumentException("Release year cannot be negative!");
        };

        this.id = UUID.randomUUID().toString(); // Правя го още в горния клас
        this.genre = genre;
        this.durationSec = durationSec;
        this.category = category;
        this.author = author;
        this.releaseYear = releaseYear;
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
}
