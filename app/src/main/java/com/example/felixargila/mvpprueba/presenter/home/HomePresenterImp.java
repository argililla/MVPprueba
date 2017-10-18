package com.example.felixargila.mvpprueba.presenter.home;

import com.example.felixargila.mvpprueba.domain.home.HomeInteractor;
import com.example.felixargila.mvpprueba.domain.home.HomeInteractorImp;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.ui.home.fragment.HomeView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;





/**
 * Created by felixargila on 18/10/17.
 */

public class HomePresenterImp  implements HomePresenter {



    private HomeInteractor interactor;
    private HomeView view;

    public HomePresenterImp(HomeView view) {
        this.view = view;
        interactor = new HomeInteractorImp(onDataLoaded);
    }

    @Override
    public void loadData() {
        interactor.loadData();

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
