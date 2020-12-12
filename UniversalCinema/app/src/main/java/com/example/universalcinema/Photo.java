package com.example.universalcinema;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Photo
{
    private int resourceId;
    private String name;
    private String genre;

    public Photo(int resourceId, String name, String genre)
    {
        this.resourceId = resourceId;
        this.genre = genre;
        this.name = name;
    }

    public int getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(int resourceId)
    {
        this.resourceId = resourceId;
    }

    public String getName()
    {
        return name;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }
}
