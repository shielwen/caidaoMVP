package com.example.administrator.caidaomvp.ActivityPresenter;

import android.support.v4.app.Fragment;

import com.example.administrator.caidaomvp.ActivityView.VideoViews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/21 0021.
 */

public class VideoViewPresenter implements BasePresenter {
    private VideoViews mvideoView;
    private List<Fragment> fragments;

    private List<String> titles;

    public VideoViewPresenter(VideoViews videoView) {
        this.mvideoView = videoView;

    }

    @Override
    public void initData() {

    }
    public void initDataVideo(String videoname){
        mvideoView.initVideoData(videoname);
    }

}
