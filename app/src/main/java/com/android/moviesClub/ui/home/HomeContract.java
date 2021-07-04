package com.android.moviesClub.ui.home;

import com.android.moviesClub.ui.base.BaseContractPresenter;

public interface HomeContract {

    interface View {
        void displayTabNames(String[] tabNames);
    }

    interface Presenter extends BaseContractPresenter<View> {
        void getTabItemNames();
    }
}
