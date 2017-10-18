package com.example.felixargila.mvpprueba.presenter;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 17/10/17.
 */

public interface MainPresenter {

    void loadData();

    interface OnDataLoaded {
        void onSuccess(Response<List<VideoItem>> response);
        void onError();
    }

}
