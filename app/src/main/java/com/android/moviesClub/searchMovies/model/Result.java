package com.android.moviesClub.searchMovies.model;

import java.io.Serializable;

public class Result implements Serializable {
    public String id;
    public String resultType;
    public String image;
    public String title;
    public String description;

    public String getId() {
        return id;
    }

    public String getResultType() {
        return resultType;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
