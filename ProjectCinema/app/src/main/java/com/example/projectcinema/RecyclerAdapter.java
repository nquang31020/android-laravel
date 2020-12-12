package com.example.projectcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.LinkedList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder>
{
    private LinkedList<Movie> list;
    private LinkedList<Comment> listCmt;
    private LayoutInflater inflater;

    public RecyclerAdapter(LinkedList<Movie> list, Context context, LinkedList<Comment> cmts)
    {
        this.list = list;
        this.listCmt = cmts;
        this.inflater = LayoutInflater.from(context);
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView movieName;
        TextView movieGenre;
        TextView moviePoint;
        TextView movieAge;
        TextView movieStatus;
        TextView txtName;
        TextView txtCmt;

        public viewHolder(@NonNull View itemView)
        {
            super(itemView);
            if(list == null)
            {
                txtCmt = itemView.findViewById(R.id.txtcmt);
                txtName = itemView.findViewById(R.id.txtname);
            }
            else
            {
                imageView = itemView.findViewById(R.id.movieImg);
                movieGenre = itemView.findViewById(R.id.movieGenre);
                movieName = itemView.findViewById(R.id.movieName);
                movieAge = itemView.findViewById(R.id.movieAge);
                moviePoint = itemView.findViewById(R.id.moviePoint);
                movieStatus = itemView.findViewById(R.id.movieStatus);
            }
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        if(list == null)
            view = inflater.inflate(R.layout.cmt_item, parent, false);
        else
            view = inflater.inflate(R.layout.slide_movie_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        if(list == null)
        {
            Comment cmts = listCmt.get(position);
            holder.txtName.setText(cmts.getName());
            holder.txtCmt.setText(cmts.getCmt());
        }
        else
        {
            Movie listPhoto = list.get(position);
            holder.imageView.setImageResource(listPhoto.getId());
            holder.movieName.setText(listPhoto.getMovieName());
            holder.movieGenre.setText(listPhoto.getMovieGenre());
            holder.movieAge.setText(listPhoto.getMovieAge());
            holder.moviePoint.setText(Integer.toString(listPhoto.getMoviePoint()));
            holder.movieStatus.setText(listPhoto.getStatus());
        }
    }

    @Override
    public int getItemCount()
    {
        if(list == null)
            return listCmt.size();
        else
            return list.size();
    }
}
