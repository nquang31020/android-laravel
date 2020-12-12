package com.example.universalcinema;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class MovieFragment extends Fragment
{
    LinkedList<Movie> ds= new LinkedList<>();
    private GridView gv;
    private String MucDaChon = "all";
    private String ChuDaNhap = "";
    private SearchView searchView;
    private Button btnShowAll;
    private Button btnDangChieu;
    private Button btnSapChieu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        ds = dsPhim();

        gv = Objects.requireNonNull(getView()).findViewById(R.id.gridView);
        MovieAdapter movieAdapter = new MovieAdapter(getContext(), ds);
        gv.setAdapter(movieAdapter);

        xuLiKhiNhap();

        btnShowAll = getView().findViewById(R.id.BtnShowAll);
        btnDangChieu = getView().findViewById(R.id.BtnDangChieu);
        btnSapChieu = getView().findViewById(R.id.BtnSapChieu);

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MucDaChon = "all";
                searchView.setQuery("", false);
                searchView.clearFocus();

                btnShowAll.setBackgroundResource(android.R.color.holo_blue_light);
                btnDangChieu.setBackgroundResource(R.color.white);
                btnSapChieu.setBackgroundResource(R.color.white);

                MovieAdapter movieAdapter = new MovieAdapter(getContext(), ds);
                gv.setAdapter(movieAdapter);
            }
        });

        btnSapChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MucDaChon = "Sắp chiếu";
                searchView.setQuery(ChuDaNhap, false);
                searchView.clearFocus();

                btnSapChieu.setBackgroundResource(android.R.color.holo_blue_light);
                btnDangChieu.setBackgroundResource(R.color.white);
                btnShowAll.setBackgroundResource(R.color.white);

                filterList("Sắp chiếu");
            }
        });

        btnDangChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MucDaChon = "Đang chiếu";
                searchView.setQuery(ChuDaNhap, false);
                searchView.clearFocus();

                btnDangChieu.setBackgroundResource(android.R.color.holo_blue_light);
                btnShowAll.setBackgroundResource(R.color.white);
                btnSapChieu.setBackgroundResource(R.color.white);

                filterList("Đang chiếu");
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    public Drawable getDrawable(String name)
    {
        String uri = "@drawable/" + name;
        int resid = getResources().getIdentifier(uri, null, getContext().getPackageName());
        Drawable drawable = getContext().getDrawable(resid);
        return drawable;
    }

    private LinkedList<Movie> dsPhim()
    {
        LinkedList<Movie> list = new LinkedList<>();
        InputStream is = Objects.requireNonNull(this.getContext()).getApplicationContext().getResources().openRawResource(R.raw.moviedata);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        String json;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(line);
            sb.append("\n");
        }
        json = sb.toString();
        try {
            JSONArray jsonArray = new JSONArray(json);
            int lenght = jsonArray.length();
            for (int i = 0; i < lenght; i++)
            {
                Movie movie= new Movie(
                getDrawable(jsonArray.getJSONObject(i).getString("anh")),
                jsonArray.getJSONObject(i).getString("ten"),
                jsonArray.getJSONObject(i).getString("theloai"),
                jsonArray.getJSONObject(i).getString("dotuoi"),
                jsonArray.getJSONObject(i).getInt("diem"),
                jsonArray.getJSONObject(i).getString("trangthai"));
                list.addLast(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void xuLiKhiNhap() {
        searchView = Objects.requireNonNull(getView()).findViewById(R.id.MovieSearch);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                LinkedList<Movie> filteredMovie = new LinkedList<>();
                ChuDaNhap = newText;

                for (Movie movie : ds) {
                    if (movie.tenPhim.toLowerCase().contains(ChuDaNhap.toLowerCase().trim())) {
                        if (MucDaChon.equals("all")) {
                            filteredMovie.addLast(movie);
                        } else {
                            if (movie.trangThai.equals(MucDaChon))
                                filteredMovie.addLast(movie);
                        }
                    }
                }
                MovieAdapter movieAdapter = new MovieAdapter(getContext(), filteredMovie);
                gv.setAdapter(movieAdapter);

                return false;
            }
        });
    }

    private void filterList(String status)
    {
        MucDaChon = status;
        LinkedList<Movie> filteredMovie = new LinkedList<>();

        for (Movie movie : ds) {
            if (movie.trangThai.equals(status)) {
                if (ChuDaNhap.equals("")) {
                    filteredMovie.addLast(movie);
                } else {
                    if (movie.tenPhim.toLowerCase().contains(ChuDaNhap)) {
                        filteredMovie.addLast(movie);
                    }
                }
            }
        }
        MovieAdapter movieAdapter = new MovieAdapter(getContext(), filteredMovie);
        gv.setAdapter(movieAdapter);
    }


}
