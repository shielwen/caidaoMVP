package com.example.administrator.caidaomvp.FragmentView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.caidaomvp.R;

/**
 * Created by Administrator on 2019/5/29 0029.
 */

public class VideoViewsRight extends Fragment implements basefragmentview{
    private Context context;
    private LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videoviewsright, container, false);
        context=getContext();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initID();
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

    }

    @Override
    public void initID() {
        linearLayout=getActivity().findViewById(R.id.right_linearlayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialogs();
            }
        });
    }

    @Override
    public void Result(String code) {

    }

    public void AlertDialogs(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog dialog = builder.create();
        final View dialogView = View.inflate(context, R.layout.fragment_videoviewsalert, null);
        //设置对话框布局
        dialog.setView(dialogView);
        dialog.show();
        final EditText etName = (EditText) dialogView.findViewById(R.id.alert_edittext);
        Button  button=(Button) dialogView.findViewById(R.id.alert_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                Toast.makeText(context,""+name,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



    }

}
