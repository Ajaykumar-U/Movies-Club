package com.android.moviesClub.searchMovies;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesClub.R;
import com.android.moviesClub.searchMovies.model.Result;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContractor.View {

    SearchView searchView;
    SearchContractor.Presenter presenter = new SearchPresenter();
    String strEditedText;
    RecyclerView recyclerViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.searchView);
        recyclerViewSearch = findViewById(R.id.recyclerViewSearch);
        recyclerViewSearch.setLayoutManager(new GridLayoutManager(this, 3));
        presenter.attachView(this);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            private Handler mHandler = new Handler();

            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.getMoviesRoot(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                strEditedText = newText;
                mHandler.removeCallbacks(mFilterTask);
                mHandler.postDelayed(mFilterTask, 200);
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    @Override
    public void getMoviesRootList(List<Result> resultsList) {
        recyclerViewSearch.setAdapter(new SearchRecyclerAdapter(resultsList));
    }

    private final Runnable mFilterTask = new Runnable() {

        @Override
        public void run() {
            if (!strEditedText.isEmpty()) {
                presenter.getMoviesRoot(strEditedText);

            }
        }
    };
}