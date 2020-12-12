package com.example.universalcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.viewHolder>
{
    private final LinkedList<BinhLuan> listCmt;
    private LayoutInflater inflater;

    public ReAdapter(Context context, LinkedList<BinhLuan> list)
    {
        listCmt = list;
        inflater = LayoutInflater.from(context);
    }
    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txtName;
        TextView txtCmt;
        ReAdapter adapter;
        public viewHolder(@NonNull View itemView, ReAdapter reAdapter) {
            super(itemView);
            txtCmt = itemView.findViewById(R.id.txtcmt);
            txtName = itemView.findViewById(R.id.txtname);
            adapter = reAdapter;
        }
    }
    @NonNull
    @Override
    public ReAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cmt_item, parent, false);
        return new viewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ReAdapter.viewHolder holder, int position) {
        BinhLuan CurrentItem = listCmt.get(position);
        holder.txtName.setText(CurrentItem.getName());
        holder.txtCmt.setText(CurrentItem.getCmt());
    }

    @Override
    public int getItemCount() {
        return listCmt.size();
    }
}
