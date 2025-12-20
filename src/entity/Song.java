package entity;

import service.utils.Validator;

public class Song extends AudioItem implements PlaylistInsertable{
    private String lyrics;
    private int rating;


    public Song(String title, String author, String genre, int durationSec, String category, int releaseYear, int rating, String lyrics) {
        super(title, author, genre, durationSec, category, releaseYear);

        Validator.validateRating(rating, "Rating");
        Validator.validateString(lyrics, "Lyrics");

        this.rating = rating;
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
