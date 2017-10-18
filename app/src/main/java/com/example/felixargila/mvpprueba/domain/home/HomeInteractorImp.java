package com.example.felixargila.mvpprueba.domain.home;

import com.example.felixargila.mvpprueba.data.api.RetrofitManager;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.home.HomePresenter;

import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 18/10/17.
 */

public class HomeInteractorImp implements HomeInteractor {


    private RetrofitManager retrofitManager;
    private HomePresenter.OnDataLoaded onDataLoaded;

    public HomeInteractorImp(HomePresenter.OnDataLoaded onDataLoaded) {
        this.onDataLoaded  = onDataLoaded;
        retrofitManager = new RetrofitManager(onRetrofitJsonResponse);
    }

    @Override
    public void loadData() {
        retrofitManager.loadVideos();
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
