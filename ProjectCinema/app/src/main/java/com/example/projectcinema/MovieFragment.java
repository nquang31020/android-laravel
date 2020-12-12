package com.example.projectcinema;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MovieFragment extends Fragment
{
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ImageAdapter adapter;
    private List<Integer> listImg;
    private Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
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

        LinkedList<Movie> list = new LinkedList<>();
        LinkedList<Comment> cmts = null;
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",10, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",9, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",8, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",7, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",6, "C18", "Đang chiếu"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this.getContext(), cmts);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView1.setAdapter(recyclerAdapter);

        super.onViewCreated(view, savedInstanceState);
    }



    private List<Integer> getListImg()
    {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.slide1);
        list.add(R.drawable.slide1);
        list.add(R.drawable.slide1);
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