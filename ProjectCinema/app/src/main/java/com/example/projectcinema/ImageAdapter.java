package com.example.projectcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.LinkedList;
import java.util.List;

public class ImageAdapter extends PagerAdapter
{
    private Context cont;
    private List<Integer> listImg;

    public ImageAdapter(Context cont, List<Integer> listImg)
    {
        this.cont = cont;
        this.listImg = listImg;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slide_item, container, false);
        ImageView ImgView = view.findViewById(R.id.slide_img);

        Integer integer  = listImg.get(position);
        if (integer != null)
            Glide.with(cont).load(integer).into(ImgView);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if (listImg != null)
            return listImg.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
