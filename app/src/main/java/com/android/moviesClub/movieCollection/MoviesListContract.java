package com.android.moviesClub.movieCollection;

import com.android.moviesClub.base.BaseContractPresenter;
import com.android.moviesClub.base.BaseContractView;

public class MoviesListContract {
    interface Presenter extends BaseContractPresenter<View> {
        void getMovieListToDisplay();
    }

    interface View extends BaseContractView {

    }
}
