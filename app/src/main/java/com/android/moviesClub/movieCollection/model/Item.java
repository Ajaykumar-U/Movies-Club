package com.android.moviesClub.movieCollection.model;

import java.io.Serializable;

public class Item implements Serializable {
    public String id;
    public String rank;
    public String title;
    public String fullTitle;
    public String year;
    public String image;
    public String crew;
    public String imDbRating;
    public String imDbRatingCount;

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", fullTitle='" + fullTitle + '\'' +
                ", year='" + year + '\'' +
                ", image='" + image + '\'' +
                ", crew='" + crew + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                ", imDbRatingCount='" + imDbRatingCount + '\'' +
                '}';
    }
}
