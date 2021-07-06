package com.android.moviesClub.movieCollection.model;

import java.util.List;

public class ArrangeMovie {
    List<Item> movieDetails;
    String movieTitle;
    public void sendData(List<Item> movieDetails, String movieTitle){
        this.movieDetails=movieDetails;
        this.movieTitle=movieTitle;
    }


}
