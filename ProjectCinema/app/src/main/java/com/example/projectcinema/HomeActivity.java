package com.example.projectcinema;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
{

    private ViewPager transPage;
    private BottomNavigationView menu;
    private LinkedList<Movie> list = new LinkedList<>();
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menu = findViewById(R.id.bottomMenu);
        transPage = findViewById(R.id.viewPager);

        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",10, "C18", "Đang chiếu"));
        list.add(new Movie(R.drawable.avengers_infinity_war, "Avenger: InfinityWar", "Siêu Anh Hùng",9, "C18", "Đang chiếu"));

        setUpViewPager();

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.menuHome:
                        transPage.setCurrentItem(0);
                        break;
                    case R.id.menuMovie:
                        transPage.setCurrentItem(1);
                        break;
                    case R.id.menuAccount:
                        transPage.setCurrentItem(2);
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
                        menu.getMenu().findItem(R.id.menuHome).setChecked(true);
                        break;
                    case 1:
                        menu.getMenu().findItem(R.id.menuMovie).setChecked(true);
                        break;
                    case 2:
                        menu.getMenu().findItem(R.id.menuAccount).setChecked(true);
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
        Intent intent = new Intent(this, MovieDetails.class);
        ImageView imageView = (ImageView) view;
        for(int i = 0; i < list.size(); i++)
        {
            if(getDrawable(list.get(i).getId()).getConstantState().equals(imageView.getDrawable().getConstantState()))
                id = list.get(i).getId();
        }
        intent.putExtra("id", id);
        startActivity(intent);
    }
}