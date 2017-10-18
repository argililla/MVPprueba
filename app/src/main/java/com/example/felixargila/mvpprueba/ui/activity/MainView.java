package com.example.felixargila.mvpprueba.ui.activity;

import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

/**
 * Created by felixargila on 17/10/17.
 */

public interface MainView {
    void updateAdapter(List<VideoItem> itemList);
}
