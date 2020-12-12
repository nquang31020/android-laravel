package com.example.universalcinema;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.LinkedList;

public class MovieAdapter extends BaseAdapter
{

    private LinkedList<Movie> ds;
    private LayoutInflater inflater;
    public MovieAdapter(Context context, LinkedList<Movie> ds)
    {
        this.ds=ds;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return ds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        convertView = inflater.inflate(R.layout.grid_view_item, null);

        ImageView img = convertView.findViewById(R.id.anhPhim);
        TextView ten = convertView.findViewById(R.id.txtTen);
        TextView theLoai = convertView.findViewById(R.id.txtTheLoai);
        TextView soTuoi = convertView.findViewById(R.id.txtSoTuoi);
        RatingBar soDiem = convertView.findViewById(R.id.rateDiem);
        TextView trangThai = convertView.findViewById(R.id.txtTrangThai);

        soDiem.setRating(ds.get(position).soDiem);
        img.setImageDrawable(ds.get(position).hinhDaiDien);
        ten.setText("Tên: "+ds.get(position).tenPhim);
        theLoai.setText("Thể loại: "+ds.get(position).theLoai);
        soTuoi.setText("Số tuổi: "+ds.get(position).doTuoi);
        trangThai.setText("Trạng thái: "+ds.get(position).trangThai);

        return convertView;
    }
}

