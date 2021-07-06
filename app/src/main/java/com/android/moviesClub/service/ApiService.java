package com.android.moviesClub.service;

import com.android.moviesClub.movieCollection.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("en/API/{tabNames}/k_8e3d1eev")
    Call<Root> getItems(@Path("tabNames") String tabNames);
}
