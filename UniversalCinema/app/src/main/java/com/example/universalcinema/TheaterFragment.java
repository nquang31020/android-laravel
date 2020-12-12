package com.example.universalcinema;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class TheaterFragment extends Fragment
{
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ImageAdapter adapter;
    private List<Photo> listImg;
    private Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.theater_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        viewPager = getView().findViewById(R.id.slidePage);
        circleIndicator = getView().findViewById(R.id.circle);

        listImg = getListImg();

        adapter = new ImageAdapter(this.getContext(), listImg);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        AutoSlideImg();

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView1);
        RecyclerView recyclerView1 = (RecyclerView) getView().findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView1.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.movie1, "Đôi mắt âm dương", "Kinh Dị"));
        list.add(new Photo(R.drawable.movie1, "Avenger InfinityWar", "Siêu Anh Hùng"));
        list.add(new Photo(R.drawable.movie1, "Mắt biết", "Tình cảm"));
        list.add(new Photo(R.drawable.movie1, "EndGame", "Siêu Anh Hùng"));
        list.add(new Photo(R.drawable.movie1, "Tiệc trăng máu", "Tâm Lý Xã Hội"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this.getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView1.setAdapter(recyclerAdapter);

        super.onViewCreated(view, savedInstanceState);
    }



    private List<Photo> getListImg()
    {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slide1, "slide 1", "slide"));
        list.add(new Photo(R.drawable.slide2, "slide 2", "slide"));
        list.add(new Photo(R.drawable.slide3, "slide 3", "slide"));
        list.add(new Photo(R.drawable.slide4, "slide 4", "slide"));
        list.add(new Photo(R.drawable.slide5, "slide 5", "slide"));
        return list;
    }

    private void AutoSlideImg()
    {
        if(listImg == null || listImg.isEmpty() || viewPager == null)
            return;
        if(timer == null)
            timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                new Handler(Looper.getMainLooper()).post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        int currentIndex = viewPager.getCurrentItem();
                        int totalIndex = listImg.size() - 1;

                        if(currentIndex < totalIndex)
                        {
                            currentIndex++;
                            viewPager.setCurrentItem(currentIndex);
                        }
                        else
                            viewPager.setCurrentItem(0);
                    }
                });
            }
        },500, 3000);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }
}
