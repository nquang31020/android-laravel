package com.example.universalcinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.print.PrintJob;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator2;
import me.relex.circleindicator.CircleIndicator3;

import static com.example.universalcinema.R.id.recyclerView;
import static com.example.universalcinema.R.layout.activity_main;

public class MainActivity extends AppCompatActivity
{
    private ViewPager transPage;
    private List<Photo> list = new ArrayList<>();
    private int id = 0;
    private BottomNavigationView menu;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        menu = findViewById(R.id.bottomMenu);
        transPage = findViewById(R.id.viewPager);

        list.add(new Photo(R.drawable.movie1, "Đôi mắt âm dương", "Kinh Dị"));
        list.add(new Photo(R.drawable.slide1, "Avenger InfinityWar", "Siêu Anh Hùng"));

        setUpViewPager();

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.home:
                        transPage.setCurrentItem(0);
                        break;
                    case R.id.theater:
                        transPage.setCurrentItem(1);
                        break;
                    case R.id.search:
                        startActivity(new Intent(MainActivity.this, FormFilter.class));
                        break;
                    case R.id.account:
                        transPage.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void setUpViewPager()
    {
        MenuAdapter adapter = new MenuAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        transPage.setAdapter(adapter);

        transPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                switch (position)
                {
                    case 0:
                        menu.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        menu.getMenu().findItem(R.id.theater).setChecked(true);
                        break;
                    case 2:
                        menu.getMenu().findItem(R.id.search).setChecked(true);
                        break;
                    case 3:
                        menu.getMenu().findItem(R.id.account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    public void chiTietPhim(View view)
    {
        Intent intent = new Intent(this, ChiTietPhim.class);
        ImageView imageView = (ImageView) view;
        for(int i = 0; i < list.size(); i++)
        {
            if(getDrawable(list.get(i).getResourceId()).getConstantState().equals(imageView.getDrawable().getConstantState()))
                id = list.get(i).getResourceId();
        }
        intent.putExtra("id", id);
        startActivity(intent);
    }
}