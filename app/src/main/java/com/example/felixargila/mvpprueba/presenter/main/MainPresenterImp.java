package com.example.felixargila.mvpprueba.presenter.main;

import com.example.felixargila.mvpprueba.domain.main.MainInteractor;
import com.example.felixargila.mvpprueba.domain.main.MainInteractorImp;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.ui.main.fragment.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;





/**
 * Created by felixargila on 18/10/17.
 */

public class MainPresenterImp implements MainPresenter {



    private MainInteractor interactor;
    private MainView view;


    public MainPresenterImp(MainView view) {
        this.view = view;
        interactor = new MainInteractorImp(onDataLoaded);
    }

    @Override
    public void loadData(String page) {
        interactor.loadData(page);

    }

    OnDataLoaded onDataLoaded = new OnDataLoaded() {
        @Override
        public void onSuccess(Response<List<VideoItem>> response) {
            List<VideoItem> itemList = parseResponseToList(response);
            view.updateAdapter(itemList);

        }

        @Override
        public void onError() {

        }
    };

    private List<VideoItem> parseResponseToList(Response<List<VideoItem>> response) {
        List<VideoItem> videoItemList = new ArrayList<>();

        for (int i=0; i < response.body().size(); i++){
            videoItemList.add(response.body().get(i));
        }
        return videoItemList;

    }
}
