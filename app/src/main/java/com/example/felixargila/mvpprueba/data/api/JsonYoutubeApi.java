package com.example.felixargila.mvpprueba.data.api;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pablorojas on 18/10/17.
 */

public interface JsonYoutubeApi {
    @GET("home.json")
    Call<List<VideoItem>>getHomeVideos();
}
