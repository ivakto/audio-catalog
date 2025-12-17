package entity;

public class Podcast extends AudioItem implements PlaylistInsertable{
    private String podcastName;
    private int episodesNum;
    private String description;

    public Podcast(String genre, int durationSec, String category, String author, String title, int releaseYear, int episodesNum, String description) {
        super(genre, durationSec, category, author, releaseYear, title);

        if (episodesNum < 0) {
            throw new IllegalArgumentException("Number of episodes cannot be negative!");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null!");
        }

        this.episodesNum = episodesNum;
        this.description = description;
    }

    public int getEpisodesNum() {
        return episodesNum;
    }

    public void setEpisodesNum(int episodesNum) {
        this.episodesNum = episodesNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
