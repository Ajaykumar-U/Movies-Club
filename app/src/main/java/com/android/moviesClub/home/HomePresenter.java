package com.android.moviesClub.home;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view = null;


    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }


}
