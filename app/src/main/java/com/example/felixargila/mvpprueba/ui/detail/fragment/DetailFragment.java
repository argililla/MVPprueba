package com.example.felixargila.mvpprueba.ui.detail.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;
import com.example.felixargila.mvpprueba.utils.transformation.CircleTransform;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailFragment extends Fragment {

@BindView(R.id.thumnailImageViewIdDetail) ImageView thumbnailImageView;
@BindView(R.id.profileImageViewIdDetail) ImageView profileImageView;
@BindView(R.id.titleDetail) TextView title;
@BindView(R.id.durationDetail) TextView duration;
@BindView(R.id.nameDetail) TextView name;
@BindView(R.id.numberOfViewsDetail) TextView numberOfViews;

VideoItem videoItemDetail;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    public VideoItem getVideoItemDetail() {
        return videoItemDetail;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(videoItemDetail != null){
            title.setText(videoItemDetail.getTitle());
            duration.setText(duration.getText()+sec2Time(videoItemDetail.getDuration()));
            name.setText(videoItemDetail.getChannel().getName());
            numberOfViews.setText(numberOfViews.getText()+formatNumberViews(videoItemDetail.getNumber_of_views()));
            Glide.with(this).load(videoItemDetail.getThumbnail_image_name()).into(thumbnailImageView);
            Glide.with(this).load(videoItemDetail.getChannel().getProfile_image_name()).transform(new CircleTransform(getContext())).into(profileImageView);
        }
    }

    public void setVideoItemDetail(VideoItem videoItemDetail) {
        this.videoItemDetail = videoItemDetail;

    }

    private String sec2Time (String duration){
        int sec = Integer.parseInt(duration);
        int min = sec / 60;
        int seg = sec % 60;
        if (seg > 9){
            return new String(min+":"+seg);
        }else {
            return new String(min+":0"+seg);
        }
    }

    private String formatNumberViews (String numberOfViews){
        double amount = Double.parseDouble(numberOfViews);
        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");
        return formatter.format(amount);

    }

}
