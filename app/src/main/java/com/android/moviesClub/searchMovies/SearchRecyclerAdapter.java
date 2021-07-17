package com.android.moviesClub.searchMovies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviesClub.R;
import com.android.moviesClub.searchMovies.model.Result;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchRecyclerAdapter extends RecyclerView.Adapter {

    List<Result> items;

    public SearchRecyclerAdapter(List<Result> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_search,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Result item = items.get(position);
        holder1.progressBar_fragment.setVisibility(View.VISIBLE);
        Picasso.get().load(item.getImage()).resize(120,200).into(holder1.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder1.progressBar_fragment.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        ProgressBar progressBar_fragment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_search);
            progressBar_fragment = itemView.findViewById(R.id.progressSearch);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Result result = items.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(),DetailsActivity.class);
            intent.putExtra("movieDetails",result);
            v.getContext().startActivity(intent);
        }
    }
}
