package com.android.moviesClub.ui.home;

import android.os.Bundle;

import com.android.moviesClub.R;
import com.android.moviesClub.ui.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    HomeContract.Presenter presenter = (HomeContract.Presenter) new HomePresenter();
    TabLayout tabLayoutHome;
    String[] tabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.attachView(this);
        presenter.getTabItemNames();

        tabLayoutHome = findViewById(R.id.tab_layout_home);
        for(String tab : tabNames){
            tabLayoutHome.addTab(tabLayoutHome.newTab().setText(tab));
        }
    }

    @Override
    protected void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }

    @Override
    public void displayTabNames(String[] tabNames) {
        this.tabNames = tabNames;
    }

}