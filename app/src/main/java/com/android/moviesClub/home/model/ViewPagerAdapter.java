package com.android.moviesClub.home.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.moviesClub.movieCollection.MoviesListFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    String tabNames[];

    public ViewPagerAdapter(FragmentManager fm, String[] tabNames) {
        super(fm);
        this.tabNames = tabNames;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        Fragment fragment;
//        Bundle bundle = new Bundle();
//        bundle.putString(MoviesListFragment.TITLE_KEY, tabNames[position]);
//        fragment = new MoviesListFragment();
//        fragment.setArguments(bundle);
        switch (position){
            case 0:
                return new MoviesListFragment(tabNames[position]);
            case 1:
                return new MoviesListFragment(tabNames[position]);
            case 2:
                return new MoviesListFragment(tabNames[position]);
            case 3:
                return new MoviesListFragment(tabNames[position]);
            case 4:
                return new MoviesListFragment(tabNames[position]);
            default:
                return new MoviesListFragment("General");
        }
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

}
