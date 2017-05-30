package com.rainbow.stopebola;

/**
 * Created by sugar on 5/27/2017.
 */

public class Post {

    private int id;
    private String status;
    private String title;
    private String date;
    private String thumbnail;

    public Post(int id, String status, String title, String date, String thumbnail) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.date = date;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setId(int id) {

        this.id = id;
    }
}
