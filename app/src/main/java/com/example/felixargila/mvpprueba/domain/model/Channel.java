package com.example.felixargila.mvpprueba.domain.model;

/**
 * Created by pablorojas on 18/10/17.
 */

public class Channel {

    private String name, profile_image_name;

    public Channel(String name, String profile_image_name) {
        this.name = name;
        this.profile_image_name = profile_image_name;
    }

    public Channel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_name() {
        return profile_image_name;
    }

    public void setProfile_image_name(String profile_image_name) {
        this.profile_image_name = profile_image_name;
    }
}