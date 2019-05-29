package com.example.administrator.caidaomvp.FragmentView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.caidaomvp.ActivityView.VideoViews;
import com.example.administrator.caidaomvp.FagmentAdapter.homeAdapter;
import com.example.administrator.caidaomvp.FragmentPresenter.HomeView_homePresenter;
import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

/**
 * Created by Administrator on 2019/5/13 0013.
 */

public class HomeView_home extends Fragment implements OnBannerListener {

    Intent mintent;
    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;//水滴刷新
    private Banner banner;//轮播图
    private HomeView_homePresenter home_homePresenter;
    private ProgressDialog mprogressDialog;
    private RecyclerView mrecyclerView;
    private homeAdapter mhomeadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeview_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mintent = new Intent(getContext(), VideoViews.class);
        home_homePresenter = new HomeView_homePresenter(this);
        home_homePresenter.initData();
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


    //访问结果
    public void initDateTopResult(boolean ret, String code) {
        if (ret) {
            Toast.makeText(getActivity(), "" + code, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "" + code, Toast.LENGTH_SHORT).show();
        }
    }


    //卡片布局
    public void initDataMiddle(List<NameModel> list) {
        mrecyclerView = getActivity().findViewById(R.id.h_recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mrecyclerView.setLayoutManager(layoutManager);
        mhomeadapter = new homeAdapter(list, this);
        mrecyclerView.setAdapter(mhomeadapter);
    }

    //刷新
    public void MiddleRefresh() {
        home_homePresenter.HttpRequestMiddleRefresh();
    }

    public void intent(String name) {
        mintent.putExtra("videoname", name);
        startActivity(mintent);
    }

    //轮播图
    public void initDataTop(List<String> list_img, List<String> list_title) {

        banner = (Banner) getView().findViewById(R.id.h_banner);
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_img);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();


    }

    //点击事件
    @Override
    public void OnBannerClick(int position) {
        String[] str = new String[]{"土豆", "肉", "饼", "粥"};

    }

    //加载图片
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
            //imageView.setImageResource((Integer) path);
        }
    }


    /*
    //水滴刷新
    public void Refresh(){
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout)getActivity().findViewById(R.id.h_main_swipes);
        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                // Do work to refresh the list here.
                Toast.makeText(getContext(),"123",Toast.LENGTH_SHORT).show();
                new Task().execute();
            }
        });
    }

    private class Task extends AsyncTask<Void, Void, String[]> {
        @Override
        protected String[] doInBackground(Void... voids) {
            return new String[0];
        }

        @Override protected void onPostExecute(String[] result) {
            // Call setRefreshing(false) when the list has been refreshed.
            mWaveSwipeRefreshLayout.setRefreshing(false);
            super.onPostExecute(result);
        }
    }

*/


    //生命周期
     /*


     @Override
    public void onStart() {
        Toast.makeText(getActivity(),"onStart",Toast.LENGTH_SHORT).show();
        super.onStart();
    }
    @Override
    public void  onResume() {
        Toast.makeText(getActivity(),"onResume",Toast.LENGTH_SHORT).show();
        super.onResume();
    }
    @Override
    public void  onPause() {
        Toast.makeText(getActivity(),"onPause",Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    public void  onStop() {
        Toast.makeText(getActivity(),"onStop",Toast.LENGTH_SHORT).show();
        super.onStop();
    }
    @Override
    public void  onDestroyView() {
        Toast.makeText(getActivity(),"onDestroyView",Toast.LENGTH_SHORT).show();
        super.onDestroyView();
    }
     */

}
