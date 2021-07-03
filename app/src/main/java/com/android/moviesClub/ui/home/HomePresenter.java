package com.android.moviesClub.ui.home;

public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View view = null;

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
