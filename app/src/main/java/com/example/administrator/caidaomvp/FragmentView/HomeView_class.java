package com.example.administrator.caidaomvp.FragmentView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.administrator.caidaomvp.FagmentAdapter.classAdapter;
import com.example.administrator.caidaomvp.FragmentPresenter.HomeView_classPresenter;
import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.R;

import java.util.List;

;

/**
 * Created by Administrator on 2019/5/13 0013.
 */

public class HomeView_class extends Fragment implements TextWatcher {
    private HomeView_classPresenter homeView_classPresenter;
    private RecyclerView recyclerView;
    private classAdapter classadapter;
    private AutoCompleteTextView autoCompleteTextView;
    private GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeview_class, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeView_classPresenter = new HomeView_classPresenter(this);
        homeView_classPresenter.initData();
        homeView_classPresenter.initDataEdittext();
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

    public void PresenterResult(String code) {
        Toast.makeText(getContext(), "" + code, Toast.LENGTH_SHORT).show();
    }

    //点击事件
    public void jumpActivity(String str) {
        Toast.makeText(getContext(), "" + str, Toast.LENGTH_SHORT).show();
    }

    //自动变化搜索
    public void initData(List<NameModel> list) {
        recyclerView = getActivity().findViewById(R.id.c_recyclerview);

        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        classadapter = new classAdapter(list, this);
        recyclerView.setAdapter(classadapter);
    }


    public void initDataEdittext(String[] list) {
        autoCompleteTextView = getActivity().findViewById(R.id.c_autocompletetextview);
        autoCompleteTextView.addTextChangedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(aa);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        homeView_classPresenter.refreshEdittext(autoCompleteTextView.getText().toString());
    }
}
