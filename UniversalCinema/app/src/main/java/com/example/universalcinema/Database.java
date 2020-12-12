package com.example.universalcinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
    public static final String DbName = "login.db";

    public Database(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, phone TEXT, email TEXT, password TEXT, birthday TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    public boolean insertData(String username, String password,String email,String phone,String birthday){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("birthday",birthday);
        long result = database.insert("users",null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean kiemTraUserName(String email){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where email = ?",new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean KiemTraTaiKhoanMatKhau(String email,String password){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where email = ? and password = ?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
