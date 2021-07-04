package com.android.moviesClub.movieCollection;

import android.util.Log;

import com.android.moviesClub.movieCollection.model.Root;
import com.android.moviesClub.service.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesListPresenter implements MoviesListContract.Presenter {

    private MoviesListContract.View view;

    @Override
    public void attachView(MoviesListContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void getMovieListToDisplay() {

        Call<Root> dataList = RetrofitBuilder.getService().getItems();
        dataList.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    Log.d("Tag2", "" + response.body());
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("TAG1", t.getMessage());
            }
        });

    }
}