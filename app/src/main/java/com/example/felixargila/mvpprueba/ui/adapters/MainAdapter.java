package com.example.felixargila.mvpprueba.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.domain.model.VideoItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felixargila on 18/10/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    private Context mContext;
    private List<VideoItem> videoItemList;

    public MainAdapter(Context mContext, List<VideoItem> videoItemList) {
        this.mContext = mContext;
        this.videoItemList = videoItemList;
    }

    public void updateList(List<VideoItem> list) {
        videoItemList.clear();
        videoItemList.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new MainAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoItem item = videoItemList.get(position);
        holder.tittleTxt.setText(item.getTitle());
        holder.subtittleTxt.setText(item.getChannel().getName());
        Glide.with(mContext).load(item.getThumbnail_image_name()).into(holder.thumbnailImageView);
        Glide.with(mContext).load(item.getChannel().getProfile_image_name()).into(holder.profileImageView);


    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.thumnailImageViewId) ImageView thumbnailImageView;
        @BindView(R.id.profileImageViewId) ImageView profileImageView;
        @BindView(R.id.tittleTxtId) TextView tittleTxt;
        @BindView(R.id.subtittleTxtId) TextView subtittleTxt;


        public MyViewHolder(View v) {
            super(v);

            ButterKnife.bind(this, v);
        }

    }
}
