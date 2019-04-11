package com.yzu.daydayrun.entity;

public class User {
    private int rgflag;
    private int id;
    private String name;
    private String password;
    private int socre;

    public int getSocre() {
        return socre;
    }

    public void setSocre(int socre) {
        this.socre = socre;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getRgflag() {
        return rgflag;
    }

    public void setRgflag(int rgflag) {
        this.rgflag = rgflag;
    }
}
