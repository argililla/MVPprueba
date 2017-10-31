package com.example.felixargila.mvpprueba.ui.main.fragment;


import android.content.Intent;
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
import com.example.felixargila.mvpprueba.ui.detail.activity.DetailActivity;
import com.example.felixargila.mvpprueba.ui.main.adapter.MainAdapter;
import com.example.felixargila.mvpprueba.ui.main.adapter.OnAdapterItemClickListener;

import java.util.ArrayList;
import java.util.List;

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
        adapter = new MainAdapter(getContext(), videoItemList, onAdapterItemClickListener);
        recyclerView.setAdapter(adapter);

        presenter.loadData(getTitle());

        return v;
    }

    private final OnAdapterItemClickListener onAdapterItemClickListener = new OnAdapterItemClickListener() {
        @Override
        public void onItemClick(VideoItem item) {

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("objetoVideo", item);
            startActivity(intent);
        }
    };

    public String getTitle() {
        Bundle args = getArguments();
        return (String) args.getCharSequence("title", "NO TITLE FOUND");
    }

    @Override
    public void updateAdapter(List<VideoItem> itemList) {
        adapter.updateList(itemList);
    }

}

