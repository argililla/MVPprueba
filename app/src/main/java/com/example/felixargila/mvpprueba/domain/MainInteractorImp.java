package com.example.felixargila.mvpprueba.domain;

import com.example.felixargila.mvpprueba.data.api.RetrofitManager;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.MainPresenter;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 17/10/17.
 */

public class MainInteractorImp  implements MainInteractor {

    private RetrofitManager retrofitManager;
    private MainPresenter.OnDataLoaded onDataLoaded;

    public MainInteractorImp(MainPresenter.OnDataLoaded onDataLoaded) {
        this.onDataLoaded  = onDataLoaded;
        retrofitManager = new RetrofitManager(this.onRetrofitJsonResponse);
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


    @Override
    public void loadData() {
        retrofitManager.loadVideos();
    }
}
