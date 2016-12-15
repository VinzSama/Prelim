package com.training.android.prelimexam;

/**
 * Created by Dyste on 12/15/2016.
 */

public class Task {

    private String Title;
    private String Desc;
    private String Time;
    private String Date;

    public Task() {
    }

    public Task(String desc, String title,String time, String date) {
        Desc = desc;
        Title = title;
        Time = time;
        Date = date;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
