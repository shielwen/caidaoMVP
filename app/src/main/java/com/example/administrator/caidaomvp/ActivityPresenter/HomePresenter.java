package com.example.administrator.caidaomvp.ActivityPresenter;

import android.support.v4.app.Fragment;

import com.example.administrator.caidaomvp.ActivityView.HomeView;
import com.example.administrator.caidaomvp.FragmentView.HomeView_class;
import com.example.administrator.caidaomvp.FragmentView.HomeView_comm;
import com.example.administrator.caidaomvp.FragmentView.HomeView_home;
import com.example.administrator.caidaomvp.FragmentView.HomeView_my;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/13 0013.
 */

public class HomePresenter {
    Fragment currentFragment = new Fragment();//设置全局碎片
    HomeView_home homeView_home = new HomeView_home();
    HomeView_class homeView_class = new HomeView_class();
    HomeView_comm homeView_comm = new HomeView_comm();
    HomeView_my homeView_my = new HomeView_my();
    List<Fragment> list = new ArrayList<>();
    HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        list.add(homeView_home);
        list.add(homeView_class);
        list.add(homeView_comm);
        list.add(homeView_my);
    }

    public void initFragment(int i) {
        homeView.switchFragment(list.get(i)).commit();
        homeView.changeImage(i);
    }
}
