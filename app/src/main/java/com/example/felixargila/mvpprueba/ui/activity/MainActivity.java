package com.example.felixargila.mvpprueba.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.data.api.JsonYoutubeApi;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.presenter.MainPresenter;
import com.example.felixargila.mvpprueba.presenter.MainPresenterImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  implements MainView, Callback<List<VideoItem>>{

    private MainPresenter presenter;
    @BindView(R.id.btn) Button btn;

    @BindView(R.id.tv1) TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImp(this);

        ButterKnife.bind(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(presenter.cambiarTexto());
            }
        });

        loadVideos();
    }

    private void loadVideos() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://s3-us-west-2.amazonaws.com/youtubeassets/").addConverterFactory(GsonConverterFactory.create(gson)).build();


        JsonYoutubeApi youtubeApi = retrofit.create(JsonYoutubeApi.class);
        Call<List<VideoItem>> call = youtubeApi.getHomeVideos();

        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<List<VideoItem>> call, Response<List<VideoItem>> response) {
        Log.v("OnResponse","--------"+ response.message());
    }

    @Override
    public void onFailure(Call<List<VideoItem>> call, Throwable t) {
        Log.v("OnFailure","--------"+ t.getLocalizedMessage());
    }
}
