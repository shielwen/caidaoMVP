package com.example.administrator.caidaomvp.FagmentAdapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.caidaomvp.FragmentView.HomeView_home;
import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.R;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/5/15 0015.
 */

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.ViewHolder> {
    private Context mcontext;
    private List<NameModel> mlist;

    private HomeView_home homeView_home;

    /*
        类方法  传参数进来
     */
    public homeAdapter(List<NameModel> list, HomeView_home homeView_home) {
        this.homeView_home = homeView_home;
        mlist = list;
    }

    /*
        获的 view 以及 holder  这样就就可以修改界面数据  用下一个重写的方法  点击事件
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment_homeview_home_cardview, parent, false);

        return new ViewHolder(view);
    }

    /*
        修改界面数据
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final NameModel food = mlist.get(position);
        holder.textView1.setText(food.getName());
        Glide.with(mcontext).load(HttpUtil.ip + "img/" + food.getName() + ".jpg").into(holder.imageView);
        final int i = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NameModel food = mlist.get(i);
                if (food.getName().equals("点我可以刷新") || food.getName().equals("菜道")) {
                    homeView_home.MiddleRefresh();

                } else {
                    homeView_home.intent(food.getName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    /*
        获取焦点
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            imageView = (ImageView) view.findViewById(R.id.imageView1);
            textView1 = (TextView) view.findViewById(R.id.textview1);
        }
    }
}
