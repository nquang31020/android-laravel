package com.example.universalcinema;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int soLuongTab;
    public PageAdapter(@NonNull FragmentManager fm, int soLuongTab) {
        super(fm);
        this.soLuongTab = soLuongTab;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ThongTin();
            case 1:
                return new GiaoDich();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return soLuongTab;
    }
}
