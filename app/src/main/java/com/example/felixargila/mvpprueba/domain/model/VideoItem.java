package com.example.felixargila.mvpprueba.domain.model;

import java.io.Serializable;

/**
 * Created by pablorojas on 18/10/17.
 */
public class VideoItem implements Serializable {

    private String title, number_of_views, thumbnail_image_name, duration;
    private Channel channel;


    public VideoItem(String title, String number_of_views, String thumbnail_image_name, Channel channel, String duration) {
        this.title = title;
        this.number_of_views = number_of_views;
        this.thumbnail_image_name = thumbnail_image_name;
        this.channel = channel;
        this.duration = duration;
    }

    public VideoItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber_of_views() {
        return number_of_views;
    }

    public void setNumber_of_views(String number_of_views) {
        this.number_of_views = number_of_views;
    }

    public String getThumbnail_image_name() {
        return thumbnail_image_name;
    }

    public void setThumbnail_image_name(String thumbnail_image_name) {
        this.thumbnail_image_name = thumbnail_image_name;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}


