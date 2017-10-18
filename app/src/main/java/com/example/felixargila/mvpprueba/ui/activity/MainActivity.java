package com.example.felixargila.mvpprueba.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.MainPresenter;
import com.example.felixargila.mvpprueba.presenter.MainPresenterImp;
import com.example.felixargila.mvpprueba.ui.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainView{

    private MainPresenter presenter;
    private MainAdapter adapter;
    private List<VideoItem> videoItemList;

    @BindView(R.id.recycler) RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImp(this);
        videoItemList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MainAdapter(this, videoItemList);
        recyclerView.setAdapter(adapter);
        presenter.loadData();


    }


    @Override
    public void updateAdapter(List<VideoItem> itemList) {
        adapter.updateList(itemList);
    }
}
