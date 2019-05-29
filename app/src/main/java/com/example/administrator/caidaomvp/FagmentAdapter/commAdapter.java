package com.example.administrator.caidaomvp.FagmentAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.administrator.caidaomvp.FragmentView.HomeView_comm;
import com.example.administrator.caidaomvp.Model.VideoModel;
import com.example.administrator.caidaomvp.R;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */

public class commAdapter extends RecyclerView.Adapter<commAdapter.ViewHolder>{
    private Context mcontext;
    private List<VideoModel> mlist;

    private HomeView_comm homeView_comm;

    public commAdapter(List<VideoModel> mlist,HomeView_comm homeView_comm){
        this.mlist=mlist;
        this.homeView_comm=homeView_comm;
    }

    @Override
    public commAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mcontext==null){
            mcontext=parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.fragment_homeview_comm_recyclerview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(commAdapter.ViewHolder holder, int position) {
        VideoModel videoModel=mlist.get(position);
        holder.mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK);//or NiceVideoPlayer.TYPE_NATIVE
        holder.mNiceVideoPlayer.setUp(HttpUtil.ip+"video/"+videoModel.getUrl()+".mp4", null);
        TxVideoPlayerController controller = new TxVideoPlayerController(mcontext);

        controller.setTitle(videoModel.getTitle());

        Glide.with(mcontext)
                .load("http://imgsrc.baidu.com/image/c0%3Dshijue%2C0%2C0%2C245%2C40/sign=304dee3ab299a9012f38537575fc600e/91529822720e0cf3f8b77cd50046f21fbe09aa5f.jpg")
                .placeholder(R.mipmap.goodpic1)
                .crossFade()
                .into(controller.imageView());
        holder.mNiceVideoPlayer.setController(controller);
    }
    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        NiceVideoPlayer mNiceVideoPlayer;

        public ViewHolder(View view) {
            super(view);
            mNiceVideoPlayer=view.findViewById(R.id.c_nice_video_player);
        }
    }
}
