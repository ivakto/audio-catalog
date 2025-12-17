package entity;

public class Song extends AudioItem implements PlaylistInsertable{
    private String lyrics;
    private int rating;


    public Song(String genre, int durationSec, String category, String author, int releaseYear, int rating, String title, String lyrics, String songName) {
        super(genre, durationSec, category, author, releaseYear, title);

        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10!");
        }
        if (lyrics == null || lyrics.isEmpty()) {
            throw new IllegalArgumentException("Lyrics cannot be empty!");
        }

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
