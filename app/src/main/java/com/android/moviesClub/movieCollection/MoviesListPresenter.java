package com.android.moviesClub.movieCollection;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.moviesClub.movieCollection.model.Item;
import com.android.moviesClub.movieCollection.model.Root;
import com.android.moviesClub.service.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

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
    public void getMovieListToDisplay(String tabTitle) {

        Call<Root> dataList = RetrofitBuilder.getService().getItems(tabTitle);
        dataList.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.code() == 200) {
                    ExecutorService service = Executors.newSingleThreadExecutor();
                    Handler handler = new Handler(Looper.getMainLooper());
                    service.execute(new Runnable() {
                        @Override
                        public void run() {
                            List<Item> movieList =response.body().getItems();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    view.getMovieList(movieList);
                                }
                            });
                        }

                    });


                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("TAG1", t.getMessage());
            }
        });

    }
}
