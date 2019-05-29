package com.example.administrator.caidaomvp.ActivityView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.caidaomvp.ActivityPresenter.HomePresenter;
import com.example.administrator.caidaomvp.R;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

public class HomeView extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private Fragment currentFragment = new Fragment();//设置全局碎片
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        build();
        homePresenter = new HomePresenter(this);
        homePresenter.initFragment(0);
    }

    public void build() {
        //下面四个图片的跳转焦点声明
        imageView1 = (ImageView) findViewById(R.id.buttom_button1);
        imageView2 = (ImageView) findViewById(R.id.buttom_button2);
        imageView3 = (ImageView) findViewById(R.id.buttom_button3);
        imageView4 = (ImageView) findViewById(R.id.buttom_button4);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttom_button1:
                homePresenter.initFragment(0);
                break;
            case R.id.buttom_button2:
                homePresenter.initFragment(1);
                break;
            case R.id.buttom_button3:
                homePresenter.initFragment(2);
                break;
            case R.id.buttom_button4:
                homePresenter.initFragment(3);
                break;
        }
    }

    //底部切换按钮
    public FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下  
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.framelayout, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction.hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

    //修改图片
    public void changeImage(int i) {
        switch (i) {
            case 0:
                imageView1.setImageResource(R.drawable.tab_menu_shouye1);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 1:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye3);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye5);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye7);
                break;

        }

    }
    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在 Activity 中 onBackPress 要交给 NiceVideoPlayer 先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

}
