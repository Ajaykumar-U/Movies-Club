package com.android.moviesClub.movieCollection.model;

import java.io.Serializable;
import java.util.List;

public class Root implements Serializable {
    public List<Item> items;
    public String errorMessage;

    public List<Item> getItems() {
        return items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Root{" +
                "items=" + items +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
