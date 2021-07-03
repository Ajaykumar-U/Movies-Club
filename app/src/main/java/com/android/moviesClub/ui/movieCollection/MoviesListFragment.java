package com.android.moviesClub.ui.movieCollection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.moviesClub.R;
import com.android.moviesClub.ui.base.BaseFragment;

public class MoviesListFragment extends BaseFragment implements MoviesListContract.View {

    MoviesListContract.Presenter presenter = new MoviesListPresenter();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}