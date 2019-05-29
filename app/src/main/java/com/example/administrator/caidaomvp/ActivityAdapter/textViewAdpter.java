package com.example.administrator.caidaomvp.ActivityAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.caidaomvp.ActivityView.SearchView;
import com.example.administrator.caidaomvp.Model.TextViewModel;
import com.example.administrator.caidaomvp.R;

import java.util.List;

/**
 * Created by Administrator on 2019/5/15 0015.
 */

public class textViewAdpter extends RecyclerView.Adapter<textViewAdpter.ViewHolder> {
    private Context mcontext;
    private List<TextViewModel> mlist;

    private SearchView searchView;

    //构造方法
    public textViewAdpter(List<TextViewModel> list, SearchView searchView) {
        this.mlist = list;
        this.searchView = searchView;
    }

    //添加布局
    @Override
    public textViewAdpter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.activity_search_view_revyclerview2, parent, false);
        return new textViewAdpter.ViewHolder(view);
    }

    //点击事件
    @Override
    public void onBindViewHolder(textViewAdpter.ViewHolder holder, final int position) {
        final TextViewModel textviewmodel = mlist.get(position);
        holder.textView1.setText(textviewmodel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.Result("" + mlist.get(position).getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    //获取焦点
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            textView1 = (TextView) view.findViewById(R.id.textview1);
        }
    }


}
