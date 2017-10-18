package com.example.felixargila.mvpprueba.presenter;

import com.example.felixargila.mvpprueba.domain.MainInteractor;
import com.example.felixargila.mvpprueba.domain.MainInteractorImp;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.ui.activity.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by felixargila on 17/10/17.
 */

public class MainPresenterImp  implements MainPresenter{

    private MainView view;
    private MainInteractor interactor;


    public MainPresenterImp(MainView view) {
        this.view = view;

        interactor = new MainInteractorImp(onDataLoaded);
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
