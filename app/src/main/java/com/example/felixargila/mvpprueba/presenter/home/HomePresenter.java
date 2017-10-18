package com.example.felixargila.mvpprueba.presenter.home;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 18/10/17.
 */

public interface HomePresenter {

    void loadData();

    interface OnDataLoaded {
        void onSuccess(Response<List<VideoItem>> response);
        void onError();
    }
}
