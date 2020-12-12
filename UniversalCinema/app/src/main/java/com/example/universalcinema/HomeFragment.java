package com.example.universalcinema;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.movie1, "Đôi mắt âm dương", "Kinh Dị"));
        list.add(new Photo(R.drawable.movie1, "Avenger InfinityWar", "Siêu Anh Hùng"));
        list.add(new Photo(R.drawable.movie1, "Mắt biết", "Tình cảm"));
        list.add(new Photo(R.drawable.movie1, "EndGame", "Siêu Anh Hùng"));
        list.add(new Photo(R.drawable.movie1, "Tiệc trăng máu", "Tâm Lý Xã Hội"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this.getContext());
        recyclerView.setAdapter(recyclerAdapter);

        super.onViewCreated(view, savedInstanceState);
    }
}
