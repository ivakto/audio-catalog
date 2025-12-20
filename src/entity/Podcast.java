package entity;

import utils.Validator;

public class Podcast extends AudioItem implements PlaylistInsertable{
    private int episodesNum;
    private String description;

    public Podcast(String title, String author, String genre, int durationSec, String category, int releaseYear, int episodesNum, String description) {
        super(title, author, genre, durationSec, category, releaseYear);

        this.episodesNum = Validator.validatePositive(episodesNum, "Number of episodes");
        this.description = Validator.validateString(description, "Description");
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
