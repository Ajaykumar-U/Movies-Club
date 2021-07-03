package com.android.moviesClub.ui.home;

import android.os.Bundle;

import com.android.moviesClub.R;
import com.android.moviesClub.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    HomeContract.Presenter presenter = (HomeContract.Presenter) new HomePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }
}