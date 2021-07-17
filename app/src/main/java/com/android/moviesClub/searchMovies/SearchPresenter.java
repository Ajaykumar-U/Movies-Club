package com.android.moviesClub.searchMovies;

import android.util.Log;

import com.android.moviesClub.searchMovies.model.Result;
import com.android.moviesClub.searchMovies.model.Roots;
import com.android.moviesClub.service.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContractor.Presenter {
    SearchContractor.View view;

    @Override
    public void attachView(SearchContractor.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }

    @Override
    public void getMoviesRoot(String results) {
        Call<Roots> dataList = RetrofitBuilder.getService().getResult(results);
        dataList.enqueue(new Callback<Roots>() {
            @Override
            public void onResponse(Call<Roots> call, Response<Roots> response) {
                if (response.isSuccessful()) {
                    Log.d("SearchP", "successf");
                    List<Result> data = response.body().getResults();
                    view.getMoviesRootList(data);
                } else {

                }
            }

            @Override
            public void onFailure(Call<Roots> call, Throwable t) {
                Log.d("SearchP", t.getMessage());
            }
        });
    }
}
