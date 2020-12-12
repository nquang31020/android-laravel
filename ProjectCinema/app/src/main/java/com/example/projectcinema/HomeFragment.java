package com.example.projectcinema;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        RecyclerView recyclerView = getView().findViewById(R.id.slideMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));

        LinkedList<Movie> list = new LinkedList<>();
        LinkedList<Comment> cmts = null;
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",10, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",9, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",8, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",7, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",6, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",5, "C18", "Sắp chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",4, "C18", "Sắp chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",3, "C18", "Sắp chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",2, "C18", "Sắp chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",1, "C18", "Sắp chiếu"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this.getContext(), cmts);
        recyclerView.setAdapter(recyclerAdapter);

        super.onViewCreated(view, savedInstanceState);
    }
}