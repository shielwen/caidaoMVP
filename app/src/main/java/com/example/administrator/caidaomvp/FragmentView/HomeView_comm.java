package com.example.administrator.caidaomvp.FragmentView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.caidaomvp.FagmentAdapter.commAdapter;
import com.example.administrator.caidaomvp.FragmentPresenter.HomeView_commPresenter;
import com.example.administrator.caidaomvp.Model.VideoModel;
import com.example.administrator.caidaomvp.R;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.List;

/**
 * Created by Administrator on 2019/5/13 0013.
 */

public class HomeView_comm extends Fragment implements basefragmentview{
    private RecyclerView mrecyclerView;
    private HomeView_commPresenter mcommPresenter;
    private commAdapter mcommadapter;

    private ViewPager mviewpager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeview_comm, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mcommPresenter=new HomeView_commPresenter(this);
        initID();
        initData();

    }


    //切换时使用
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //Fragment隐藏时调用    
        } else {
            //Fragment显示时调用

        }
    }


    @Override
    public void initData() {
            mcommPresenter.initData();
    }

    @Override
    public void initID() {
        mrecyclerView=getActivity().findViewById(R.id.comm_recyclerview);
    }
  public void initAdapter(List<VideoModel> list){
        Toast.makeText(getContext(),""+list.size(),Toast.LENGTH_SHORT).show();

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        mrecyclerView.setLayoutManager(layoutManager);
        mcommadapter = new commAdapter(list,this);
        mrecyclerView.setAdapter(mcommadapter);
    }

    //viewpager
    public void initViewPager(){

    }
    @Override
    public void Result(String code) {

    }
    @Override
    public void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }




}
