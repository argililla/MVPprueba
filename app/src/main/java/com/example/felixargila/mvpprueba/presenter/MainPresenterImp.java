package com.example.felixargila.mvpprueba.presenter;

import com.example.felixargila.mvpprueba.domain.MainInteractor;
import com.example.felixargila.mvpprueba.domain.MainInteractorImp;
import com.example.felixargila.mvpprueba.ui.activity.MainView;

/**
 * Created by felixargila on 17/10/17.
 */

public class MainPresenterImp  implements MainPresenter{

    private MainView mainview;
    private MainInteractor interactor;

    public MainPresenterImp(MainView mainview) {
        this.mainview = mainview;

        interactor = new MainInteractorImp();
    }

    @Override
    public String cambiarTexto() {
        String texto = interactor.getTexto();

        return texto;

    }
}
