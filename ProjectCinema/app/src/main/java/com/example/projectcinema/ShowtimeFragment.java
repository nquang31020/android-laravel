package com.example.projectcinema;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ShowtimeFragment extends Fragment
{
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.fragment_showtime,container,false);
        Spinner spnProvince = (Spinner)mRootView.findViewById(R.id.spnProvince);
        List<String> list = new ArrayList<>();
        list.add("TP HCM");
        list.add("Bình Dương");
        list.add("Đồng Nai");
        list.add("Long An");
        list.add("Đồng Tháp");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, list);
        spnProvince.setAdapter(adapter);
        Spinner spnRap =(Spinner)mRootView.findViewById(R.id.spnRap);
        List<String> listRap = new ArrayList<>();
        listRap.add("Rạp TP HCM");
        listRap.add("Rạp Bình Dương");
        listRap.add("Rạp Đồng Nai");
        listRap.add("Rạp Long An");
        listRap.add("Rạp Đồng Tháp");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getContext(), R.layout.support_simple_spinner_dropdown_item ,listRap);
        spnRap.setAdapter(adapter1);
        return mRootView;
    }
}