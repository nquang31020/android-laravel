package com.example.universalcinema;

import android.graphics.drawable.Drawable;

public class Movie {
    Drawable hinhDaiDien;
    String tenPhim;
    String theLoai;
    String doTuoi;
    int soDiem;
    String trangThai;

    public Movie(Drawable hinhDaiDien, String tenPhim, String theLoai, String doTuoi, int soDiem, String trangThai) {
        this.hinhDaiDien=hinhDaiDien;
        this.tenPhim=tenPhim;
        this.theLoai=theLoai;
        this.doTuoi=doTuoi;
        this.soDiem=soDiem;
        this.trangThai=trangThai;
    }

}
