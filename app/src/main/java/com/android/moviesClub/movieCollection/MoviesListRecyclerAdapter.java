package com.android.moviesClub.movieCollection;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesClub.R;
import com.android.moviesClub.movieCollection.model.Item;
import com.android.moviesClub.movieDetails.MovieDetailsActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesListRecyclerAdapter extends RecyclerView.Adapter<MoviesListRecyclerAdapter.ViewHolder> {
    List<Item> movieDetailsList;

    public MoviesListRecyclerAdapter(List<Item> movieDetailsList) {
        this.movieDetailsList = movieDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder1, int position) {
        Item item = movieDetailsList.get(position);
        String imageUrl = item.getImage();
        holder1.progressFragment.setVisibility(View.VISIBLE);
        Picasso.get()
                .load(imageUrl)
                .into(holder1.ivRecyclerFragment, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder1.progressFragment.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return movieDetailsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivRecyclerFragment;
        ProgressBar progressFragment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecyclerFragment = itemView.findViewById(R.id.image_view_fragment);
            progressFragment = itemView.findViewById(R.id.progressFragment);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Item item = movieDetailsList.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), MovieDetailsActivity.class);
            intent.putExtra("MovieDetails", item);
            v.getContext().startActivity(intent);
        }
    }
}
