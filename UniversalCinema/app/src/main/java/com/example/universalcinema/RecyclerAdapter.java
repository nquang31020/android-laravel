package com.example.universalcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    List<Photo> list;
    Context context;

    public RecyclerAdapter(List<Photo> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView movieName;
        TextView movieGenre;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.movieImage);
            movieGenre = itemView.findViewById(R.id.movieGenre);
            movieName = itemView.findViewById(R.id.movieName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Photo listPhoto = list.get(position);
        holder.imageView.setImageResource(listPhoto.getResourceId());
        holder.imageView.setContentDescription(listPhoto.getName());
        holder.movieName.setText(listPhoto.getName());
        holder.movieGenre.setText(listPhoto.getGenre());
    }

    @Override
    public int getItemCount() { return list.size(); }
}
