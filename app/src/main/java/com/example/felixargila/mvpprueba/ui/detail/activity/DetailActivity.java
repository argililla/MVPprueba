package com.example.felixargila.mvpprueba.ui.detail.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.ui.detail.fragment.DetailFragment;

public class DetailActivity extends AppCompatActivity {


    private DetailFragment detailFragment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        VideoItem videoItem = (VideoItem) getIntent().getSerializableExtra("objetoVideo");

        fragmentManager = getSupportFragmentManager();
        detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.detailFragment);
        detailFragment.setVideoItemDetail(videoItem);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.commit();

    }
}
