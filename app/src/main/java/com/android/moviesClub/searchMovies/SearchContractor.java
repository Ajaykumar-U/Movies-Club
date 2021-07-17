package com.android.moviesClub.searchMovies;

import com.android.moviesClub.base.BaseContractPresenter;
import com.android.moviesClub.searchMovies.model.Result;

import java.util.List;

public interface SearchContractor {
    interface View{
        void getMoviesRootList(List<Result> resultsList);
    }

    interface Presenter extends BaseContractPresenter<View> {
        void getMoviesRoot(String results);
    }
}
