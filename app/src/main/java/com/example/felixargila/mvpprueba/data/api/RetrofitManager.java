package com.example.felixargila.mvpprueba.data.api;

import com.example.felixargila.mvpprueba.domain.main.MainInteractor;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felixargila on 18/10/17.
 */

public class RetrofitManager implements Callback<List<VideoItem>> {

    MainInteractor.OnRetrofitJsonResponse onRetrofitJsonResponse;
    private static String BASE_URL = "https://s3-us-west-2.amazonaws.com/youtubeassets/";


    public RetrofitManager(MainInteractor.OnRetrofitJsonResponse onRetrofitJsonResponse) {
        this.onRetrofitJsonResponse = onRetrofitJsonResponse;
    }



    public void loadVideos(String page) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        RetrofitEndpointApi api = retrofit.create(RetrofitEndpointApi.class);
        Call<List<VideoItem>> call = null;
        switch (page){
            case "0":
                 call = api.getHomeVideos();
                break;
            case "1":
                call = api.getTrendingVideos();
                break;
            case "2":
                call = api.getSubscriptionsVideos();
                break;
            case "3":
            default:
                break;
        }
        if (call !=  null){
            call.enqueue(this);
        }

    }

    @Override
    public void onResponse(Call<List<VideoItem>> call, Response<List<VideoItem>> response) {
        onRetrofitJsonResponse.onSuccess(response);

    }

    @Override
    public void onFailure(Call<List<VideoItem>> call, Throwable t) {
        onRetrofitJsonResponse.onError();
    }
}
