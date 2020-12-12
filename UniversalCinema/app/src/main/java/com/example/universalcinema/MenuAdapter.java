package com.example.universalcinema;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MenuAdapter extends FragmentStatePagerAdapter
{
    public MenuAdapter(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new TheaterFragment();
            case 2:
                return new MovieFragment();
            case 3:
                return new AccountFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 4;
    }
}
