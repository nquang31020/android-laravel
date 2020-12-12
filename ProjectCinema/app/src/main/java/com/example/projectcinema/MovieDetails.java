package com.example.projectcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MovieDetails extends AppCompatActivity
{
    private ViewPager mVPDetailsMovie;
    private ImageView imgMain;
    private ImageView imgPoster;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imgMain = findViewById(R.id.imageMain);
        imgPoster = findViewById(R.id.imagePoster);

        Intent intent = this.getIntent();
        id = intent.getIntExtra("id", 0);

        imgMain.setImageResource(id);
        imgPoster.setImageResource(id);

        mVPDetailsMovie = findViewById(R.id.viewDetailsMovie);
        mVPDetailsMovie.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabDetailsMovie);
        tabLayout.setupWithViewPager(mVPDetailsMovie);
    }
}