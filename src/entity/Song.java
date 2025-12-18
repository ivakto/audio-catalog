package entity;

public class Song extends AudioItem implements PlaylistInsertable{
    private String lyrics;
    private int rating;


    public Song(String title, String author, String genre, int durationSec, String category, int releaseYear, int rating, String lyrics) {
        super(title, author, genre, durationSec, category, releaseYear);

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
