package com.android.moviesClub.movieCollection;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesClub.R;
import com.android.moviesClub.movieCollection.model.Item;
import com.android.moviesClub.movieDetails.MovieDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesListRecyclerAdapter extends RecyclerView.Adapter {
    List<Item> movieDetailsList;
    public MoviesListRecyclerAdapter(List<Item> movieDetailsList) {
        this.movieDetailsList = movieDetailsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder)holder;
        Item item = movieDetailsList.get(position);
        String imageUrl = item.getImage();
        Picasso.get().load(imageUrl).into(holder1.ivRecyclerFragment);
    }

    @Override
    public int getItemCount() {
        if(movieDetailsList.size()>=30){
            return 30;
        }
        else
            return movieDetailsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivRecyclerFragment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecyclerFragment = itemView.findViewById(R.id.image_view_fragment);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Item item = movieDetailsList.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), MovieDetailsActivity.class);
            intent.putExtra("MovieDetails",item);
            v.getContext().startActivity(intent);
        }
    }
}
