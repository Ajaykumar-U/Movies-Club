package com.android.moviesClub.ui.movieCollection;

public class MoviesListPresenter implements MoviesListContract.Presenter {

    private MoviesListContract.View view;

    @Override
    public void attachView(MoviesListContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view=null;
    }
}
