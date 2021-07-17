package com.android.moviesClub.movieCollection;

import com.android.moviesClub.movieCollection.model.Item;
import com.android.moviesClub.movieCollection.model.Root;
import com.android.moviesClub.service.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void getMovieListToDisplay(String tabTitle) {

        Call<Root> dataList = RetrofitBuilder.getService().getItems(tabTitle);
        dataList.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    List<Item> movieList = response.body().getItems();
                    view.getMovieList(movieList);
                } else {
                    view.onError("some thing went wrong");
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                view.onError("some thing went wrong");
            }
        });
    }
}
