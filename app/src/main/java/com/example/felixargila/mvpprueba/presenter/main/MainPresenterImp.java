package com.example.felixargila.mvpprueba.presenter.main;

import com.example.felixargila.mvpprueba.domain.main.MainInteractor;
import com.example.felixargila.mvpprueba.domain.main.MainInteractorImp;
import com.example.felixargila.mvpprueba.ui.main.activity.MainView;

/**
 * Created by felixargila on 17/10/17.
 */

public class MainPresenterImp  implements MainPresenter {

    private MainView view;
    private MainInteractor interactor;


    public MainPresenterImp(MainView view) {
        this.view = view;

        interactor = new MainInteractorImp();
    }

}
