package com.example.administrator.caidaomvp.Demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.caidaomvp.FragmentView.HomeView_home_first;
import com.example.administrator.caidaomvp.FragmentView.HomeView_home_second;
import com.example.administrator.caidaomvp.FragmentView.HomeView_home_third;
import com.example.administrator.caidaomvp.R;

import java.util.ArrayList;
import java.util.List;

public class text extends AppCompatActivity {
    String[] mTitles = {"首页", "热门"};//标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        setVp();
    }

    private void setVp() {
        final List<Fragment> list = new ArrayList<>();
        HomeView_home_first fragment1 = new HomeView_home_first();
        HomeView_home_second fragment2 = new HomeView_home_second();

        Bundle bundle = new Bundle();
        //bundle.putString("content","第"+i+"个Fragment");
        //fragment.setArguments(bundle);
        list.add(fragment1);
        list.add(fragment2);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

}
