package com.android.moviesClub.home;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.android.moviesClub.R;
import com.android.moviesClub.base.BaseActivity;
import com.android.moviesClub.home.model.ViewPagerAdapter;
import com.android.moviesClub.movieCollection.MoviesListFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    HomeContract.Presenter presenter = (HomeContract.Presenter) new HomePresenter();
    TabLayout tabLayoutHome;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.attachView(this);

        tabLayoutHome = findViewById(R.id.tab_layout_home);
        viewPager = findViewById(R.id.view_pager_home);

        String[] tabsTitle = getResources().getStringArray(R.array.home_tabs_title);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabsTitle);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(5);

        tabLayoutHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                MoviesListFragment fragment = (MoviesListFragment) viewPagerAdapter.getItem(tab.getPosition());
                fragment.onTabChange(tabsTitle[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}

        });
    }

    @Override
    protected void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }
}