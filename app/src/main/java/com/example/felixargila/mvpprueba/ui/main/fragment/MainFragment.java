package com.example.felixargila.mvpprueba.ui.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.main.MainPresenter;

import com.example.felixargila.mvpprueba.presenter.main.MainPresenterImp;
import com.example.felixargila.mvpprueba.ui.main.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainView {

    private MainAdapter adapter;
    private List<VideoItem> videoItemList;
    private RecyclerView recyclerView;
    private MainPresenter presenter;



    public MainFragment() {
        presenter = new MainPresenterImp(this);
    }

    public static MainFragment newInstance(String title) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putCharSequence("title", title);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        videoItemList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainAdapter(getContext(), videoItemList);
        recyclerView.setAdapter(adapter);

        presenter.loadData(getTitle());

        return v;
    }


    public String getTitle() {
        Bundle args = getArguments();
        return (String) args.getCharSequence("title", "NO TITLE FOUND");
    }

    @Override
    public void updateAdapter(List<VideoItem> itemList) {
        adapter.updateList(itemList);
    }

}
