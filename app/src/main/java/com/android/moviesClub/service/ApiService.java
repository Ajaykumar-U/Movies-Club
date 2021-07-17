package com.android.moviesClub.service;

import com.android.moviesClub.movieCollection.model.Root;
import com.android.moviesClub.searchMovies.model.Roots;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("en/API/{tabNames}/k_8e3d1eev")
    Call<Root> getItems(@Path("tabNames") String tabNames);

    @GET("en/API/SearchMovie/k_jn5jkhzx/{movieName}")
    Call<Roots> getResult(@Path("movieName") String movieName);
}
