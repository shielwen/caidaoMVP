package com.example.administrator.caidaomvp.FagmentAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.caidaomvp.FragmentView.HomeView_class;
import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.R;

import java.util.List;

/**
 * Created by Administrator on 2019/5/15 0015.
 */

public class classAdapter extends RecyclerView.Adapter<classAdapter.ViewHolder> {
    private Context mcontext;
    private List<NameModel> mlist;

    private HomeView_class homeView_class;

    /*
        类方法  传参数进来
     */
    public classAdapter(List<NameModel> list, HomeView_class homeView_class) {
        this.homeView_class = homeView_class;
        this.mlist = list;
    }

    /*
        获的 view 以及 holder  这样就就可以修改界面数据  用下一个重写的方法  点击事件
     */
    @Override
    public classAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment_homeview_class_recyclerview, parent, false);
        return new classAdapter.ViewHolder(view);
    }

    /*
        修改界面数据
     */
    @Override
    public void onBindViewHolder(final classAdapter.ViewHolder holder, int position) {
        final NameModel food = mlist.get(position);
        holder.textView1.setText(food.getName());
        final int i = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NameModel food = mlist.get(i);
                homeView_class.jumpActivity(food.getName());
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
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            textView1 = (TextView) view.findViewById(R.id.textview1);
        }
    }
}
