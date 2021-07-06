package com.android.moviesClub.movieCollection;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesClub.R;
import com.android.moviesClub.base.BaseFragment;
import com.android.moviesClub.movieCollection.model.Item;

import java.util.List;

public class MoviesListFragment extends BaseFragment implements MoviesListContract.View {

    MoviesListContract.Presenter presenter = new MoviesListPresenter();
    String tabTitle;
    RecyclerView recyclerViewMovieCollection;


    public MoviesListFragment(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
        presenter.getMovieListToDisplay(tabTitle);
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
        recyclerViewMovieCollection = view.findViewById(R.id.recycler_view_Fragment);
        recyclerViewMovieCollection.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    public void onTabChange(String title) {
        Log.d("Tag1",title);
    }

    @Override
    public void getMovieList(List<Item> movieList) {
        recyclerViewMovieCollection.setAdapter(new MoviesListRecyclerAdapter(movieList));
    }
}