package com.android.moviesClub.movieCollection;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.moviesClub.R;
import com.android.moviesClub.base.BaseFragment;

public class MoviesListFragment extends BaseFragment implements MoviesListContract.View {

    public static final String TITLE_KEY = "title_key";
    private static final String TAG = "MoviesListFragment";
    MoviesListContract.Presenter presenter = new MoviesListPresenter();
    TextView textView;
    String title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        title = getArguments().getString(TITLE_KEY);
    }

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
        textView = view.findViewById(R.id.tvFragmentDisplay);
        textView.setText(title);
        presenter.getMovieListToDisplay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    public void onTabChange(String title) {
        Log.e(TAG, "setTitle: " + title);
    }
}