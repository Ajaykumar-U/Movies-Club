package com.android.moviesClub.movieDetails;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.moviesClub.R;
import com.android.moviesClub.movieCollection.model.Item;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView ivActivityMovieDetails;
    TextView tvActivityMovieDetailsTitle,tvActivityMovieDetailsPage;

    String title;
    String fulltitle;
    String year=null;
    String crew=null;
    String imDBRating =null;
    String rank = null;
    String moviesDetails="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ivActivityMovieDetails = findViewById(R.id.iv_activity_movie_details);
        tvActivityMovieDetailsTitle = findViewById(R.id.tv_activityMovieDetails_title);
        tvActivityMovieDetailsPage = findViewById(R.id.tv_activityMovieDetails_page);

        Item item = (Item) getIntent().getSerializableExtra("MovieDetails");
        title = item.getTitle();
        fulltitle = item.getFullTitle();
        year = item.year;
//        crew = item.getCrew();
        imDBRating = item.getImDbRating();
        rank = item.getRank();
        crew = item.getCrew();
        if(fulltitle!=null){
            moviesDetails +="\nFull Title: "+ fulltitle+"\n\n";
        }
        if(year!=null){
            moviesDetails +="Year of Release: "+ year+"\n\n";
        }
        if(imDBRating !=null){
            moviesDetails +="ImDB Rating: "+ imDBRating +"\n\n";
        }
        if(rank!=null){
            moviesDetails +="Rank: "+ rank+"\n\n";
        }
        if(crew!=null){
            moviesDetails +="Crew: "+ crew;
        }

        tvActivityMovieDetailsTitle.setText(title);
        tvActivityMovieDetailsPage.setText(moviesDetails);
        Picasso.get().load(item.getImage()).into(ivActivityMovieDetails);
    }
}