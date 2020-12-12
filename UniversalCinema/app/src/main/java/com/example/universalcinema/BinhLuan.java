package com.example.universalcinema;

public class BinhLuan
{
    private String Name;
    private String Cmt;

    public BinhLuan(String name, String cmt) {
        Name = name;
        Cmt = cmt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCmt() {
        return Cmt;
    }

    public void setCmt(String cmt) {
        Cmt = cmt;
    }
}
