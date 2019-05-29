package com.example.administrator.caidaomvp.FragmentPresenter;

import com.example.administrator.caidaomvp.FragmentView.HomeView_comm;
import com.example.administrator.caidaomvp.Model.VideoModel;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */

public class HomeView_commPresenter {
    private HomeView_comm mhomeView_comm;
    private List<VideoModel> mlist;
    public HomeView_commPresenter(HomeView_comm homeView_comm){
        this.mhomeView_comm=homeView_comm;
        mlist=new ArrayList<>();
    }
    public void initData(){
        VideoModel videoModel=new VideoModel();
        videoModel.setImage(HttpUtil.ip + "/img/img1.jpg");
        videoModel.setTitle("123456");
        videoModel.setUrl("video");
        mlist.add(videoModel);
        mlist.add(videoModel);
        mlist.add(videoModel);
        mlist.add(videoModel);
        mlist.add(videoModel);
        mhomeView_comm.initAdapter(mlist);
    }
}
