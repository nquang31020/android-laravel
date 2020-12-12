package com.example.projectcinema;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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
                return new MovieFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
