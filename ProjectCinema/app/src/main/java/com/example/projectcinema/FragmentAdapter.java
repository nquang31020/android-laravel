package com.example.projectcinema;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter
{
    private String listTab[] = {"Lịch chiếu", "Thông tin", "Bình luận"};
    private ShowtimeFragment mLichChieuFrag;
    private InfoFragment mThongTinFrag;
    private CommentFragment mBinhLuanFrag;

    public FragmentAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
        mLichChieuFrag = new ShowtimeFragment();
        mThongTinFrag = new InfoFragment();
        mBinhLuanFrag = new CommentFragment();
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
