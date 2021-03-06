package com.example.felixargila.mvpprueba.domain.main;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 18/10/17.
 */

public interface MainInteractor {
    void loadData(String page);

    interface OnRetrofitJsonResponse {
        void onSuccess(Response<List<VideoItem>> response);
        void onError();
    }
}
