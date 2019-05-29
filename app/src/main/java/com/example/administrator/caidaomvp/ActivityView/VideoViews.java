package com.example.administrator.caidaomvp.ActivityView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.administrator.caidaomvp.ActivityPresenter.VideoViewPresenter;
import com.example.administrator.caidaomvp.FragmentView.VideoViewsLeft;
import com.example.administrator.caidaomvp.FragmentView.VideoViewsRight;
import com.example.administrator.caidaomvp.R;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;

public class VideoViews extends AppCompatActivity implements BaseView {
    private VideoViewPresenter mvideoViewPresenter;
    private Intent mintent;


    private NiceVideoPlayer mNiceVideoPlayer;


    //左右切换的fragment
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private List<String> titles;
    private VideoViewsLeft videoViewsLeft;
    private VideoViewsRight videoViewsRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        mvideoViewPresenter = new VideoViewPresenter(this);
        initID();
        initData();
    }

    @Override
    public void initData() {
        mintent = getIntent();
        String videoname = mintent.getStringExtra("videoname");
        mvideoViewPresenter.initDataVideo("vas");
        initViewPager1();
        initViewPager2();
    }

    public void initVideoData(String ss) {
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        mNiceVideoPlayer.setUp(HttpUtil.ip+"video/"+ss+".mp4", null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle( ss);
        Glide.with(this)
                .load("http://imgsrc.baidu.com/image/c0%3Dshijue%2C0%2C0%2C245%2C40/sign=304dee3ab299a9012f38537575fc600e/91529822720e0cf3f8b77cd50046f21fbe09aa5f.jpg")
                .placeholder(R.mipmap.goodpic1)
                .crossFade()
                .into(controller.imageView());
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    public void  initID(){
        mNiceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
    }

    @Override
    public void Result(String code) {

    }
    @Override
    protected void onStop() {
        super.onStop();
        // 在 onStop 时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在 Activity 中 onBackPress 要交给 NiceVideoPlayer 先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }


    private void initViewPager1() {

        titles = new ArrayList<>();
        titles.add("食谱详情");
        titles.add("评论");


        fragments = new ArrayList<>();
        videoViewsLeft=new VideoViewsLeft();
        videoViewsRight=new VideoViewsRight();
        fragments.add(videoViewsLeft);
        fragments.add(videoViewsRight);

    }

    //初始化数据
    private void initViewPager2() {
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        //预加载
        viewPager.setOffscreenPageLimit(fragments.size());

        //设置适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的ITem
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }
            //返回Item个数
            @Override
            public int getCount() {
                return fragments.size();
            }
            //设置标题
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }

}
