package com.android.moviesClub.ui.home;

import com.android.moviesClub.ui.home.model.TabNames;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view = null;
    private TabNames tabNames;

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void getTabItemNames() {
        tabNames = new TabNames();
        String[] tabNamesList = tabNames.getTabNmaes();
        view.displayTabNames(tabNamesList);
    }
}
