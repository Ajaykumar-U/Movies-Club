package com.android.moviesClub.movieCollection;

import com.android.moviesClub.base.BaseContractPresenter;
import com.android.moviesClub.base.BaseContractView;
import com.android.moviesClub.movieCollection.model.Item;

import java.util.List;

public class MoviesListContract {
    interface Presenter extends BaseContractPresenter<View> {
        void getMovieListToDisplay(String tabTitle);
    }

    interface View extends BaseContractView {
        void getMovieList(List<Item> movieList);
    }
}
