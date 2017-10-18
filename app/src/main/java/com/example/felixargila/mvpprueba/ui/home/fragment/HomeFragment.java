package com.example.felixargila.mvpprueba.ui.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.home.HomePresenter;
import com.example.felixargila.mvpprueba.presenter.home.HomePresenterImp;
import com.example.felixargila.mvpprueba.ui.home.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView {

    private HomeAdapter adapter;
    private List<VideoItem> videoItemList;
    private RecyclerView recyclerView;
    private HomePresenter presenter;

    public HomeFragment() {
        presenter = new HomePresenterImp(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        videoItemList = new ArrayList<>();

        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeAdapter(getContext(), videoItemList);
        recyclerView.setAdapter(adapter);

        presenter.loadData();
        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void updateAdapter(List<VideoItem> itemList) {
        adapter.updateList(itemList);
    }
}
