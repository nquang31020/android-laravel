package com.example.universalcinema;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private String listTab[] = {"Lịch chiếu", "Thông tin", "Bình luận"};
    private LichChieuFrag mLichChieuFrag;
    private ThongTinFrag mThongTinFrag;
    private BinhLuanFrag mBinhLuanFrag;
    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mLichChieuFrag = new LichChieuFrag();
        mThongTinFrag = new ThongTinFrag();
        mBinhLuanFrag = new BinhLuanFrag();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return mLichChieuFrag;
        }else if (position==1){
            return mThongTinFrag;
        }else {
            return mBinhLuanFrag;
        }
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
