package com.example.felixargila.mvpprueba.ui.home.fragment;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

/**
 * Created by felixargila on 18/10/17.
 */

public interface HomeView {

    void updateAdapter(List<VideoItem> itemList);
}
