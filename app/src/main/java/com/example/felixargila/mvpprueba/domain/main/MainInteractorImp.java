package com.example.felixargila.mvpprueba.domain.main;

import com.example.felixargila.mvpprueba.data.api.RetrofitManager;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.main.MainPresenter;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 18/10/17.
 */

public class MainInteractorImp implements MainInteractor {


    private RetrofitManager retrofitManager;
    private MainPresenter.OnDataLoaded onDataLoaded;

    public MainInteractorImp(MainPresenter.OnDataLoaded onDataLoaded) {
        this.onDataLoaded  = onDataLoaded;
        retrofitManager = new RetrofitManager(onRetrofitJsonResponse);
    }

    @Override
    public void loadData(String page) {
        retrofitManager.loadVideos(page);
    }


    private OnRetrofitJsonResponse onRetrofitJsonResponse = new OnRetrofitJsonResponse() {
        @Override
        public void onSuccess(Response<List<VideoItem>> response) {
            onDataLoaded.onSuccess(response);
        }

        @Override
        public void onError() {
            onDataLoaded.onError();
        }
    };
}
