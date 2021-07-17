package com.android.moviesClub.searchMovies;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.moviesClub.R;
import com.android.moviesClub.searchMovies.model.Result;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    TextView tvActivityMovieDetailsTitle,tvActivityMovieDetailsPage;
    ImageView ivActivityMovieDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvActivityMovieDetailsTitle = findViewById(R.id.tv_activityMovieDetails_title);
        ivActivityMovieDetails = findViewById(R.id.iv_activity_movie_details);
        tvActivityMovieDetailsPage = findViewById(R.id.tv_activityMovieDetails_page);
        Result result = (Result) getIntent().getSerializableExtra("movieDetails");
        String strDetails ="\nTitle: "+ result.getTitle() + "\n\nDescription: " + result.getDescription();
        Picasso.get().load(result.getImage()).into(ivActivityMovieDetails);
        tvActivityMovieDetailsTitle.setText(result.getTitle());
        tvActivityMovieDetailsPage.setText(strDetails);
    }
}
