package com.android.moviesClub.movieCollection;

import android.os.Bundle;
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

    private MoviesListContract.Presenter presenter = new MoviesListPresenter();
    private String tabTitle;
    private RecyclerView recyclerViewMovieCollection;

    public MoviesListFragment(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        presenter.getMovieListToDisplay(tabTitle);
        recyclerViewMovieCollection = view.findViewById(R.id.recycler_view_Fragment);
        recyclerViewMovieCollection.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public void getMovieList(List<Item> movieList) {
        recyclerViewMovieCollection.setAdapter(new MoviesListRecyclerAdapter(movieList));
    }

    @Override
    public void onError(String errorMsg){
     // todo show error ui
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}