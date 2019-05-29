package com.example.administrator.caidaomvp.ActivityView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.administrator.caidaomvp.ActivityAdapter.textViewAdpter;
import com.example.administrator.caidaomvp.ActivityPresenter.SearchPresenter;
import com.example.administrator.caidaomvp.Model.TextViewModel;
import com.example.administrator.caidaomvp.R;

import java.util.List;

public class SearchView extends AppCompatActivity implements TextWatcher {
    private SearchPresenter msearchPresenter;

    private textViewAdpter mtextViewadapter1;
    private textViewAdpter mtextViewadapter2;
    private textViewAdpter mtextViewadapter3;
    private RecyclerView mrecyclerView1;
    private RecyclerView mrecyclerView2;
    private RecyclerView mrecyclerView3;
    private GridLayoutManager mgridLayoutManager;
    private StaggeredGridLayoutManager mstaggeredGridLayoutManager1;
    private StaggeredGridLayoutManager mstaggeredGridLayoutManager2;
    private StaggeredGridLayoutManager mstaggeredGridLayoutManager3;

    private AutoCompleteTextView autoCompleteTextView;
    //设置布局管理器
    //1、第一种LinearLayoutManager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    //2、第二种 GridLayoutManager
//        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
    //3、第三种
    //  StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        //设置布局的排版方向
//        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
    // mRecyclerView.setLayoutManager(layoutManager);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        initID();
        msearchPresenter = new SearchPresenter(this);
        msearchPresenter.initData();
    }

    public void initID() {
        autoCompleteTextView = findViewById(R.id.autocompletetextview);
        autoCompleteTextView.addTextChangedListener(this);
    }

    public void Result(String code) {
        Toast.makeText(SearchView.this, "" + code, Toast.LENGTH_SHORT).show();
    }

    public void initDataTop(List<TextViewModel> list) {
        mrecyclerView1 = findViewById(R.id.recyclerview1);
        mgridLayoutManager = new GridLayoutManager(this, 1);
        mrecyclerView1.setLayoutManager(mgridLayoutManager);
        mtextViewadapter1 = new textViewAdpter(list, this);
        mrecyclerView1.setAdapter(mtextViewadapter1);

    }

    public void initDataHot(List<TextViewModel> list) {
        mrecyclerView2 = findViewById(R.id.recyclerview2);
        mstaggeredGridLayoutManager2 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mstaggeredGridLayoutManager2.setOrientation(GridLayoutManager.VERTICAL);
        mrecyclerView2.setLayoutManager(mstaggeredGridLayoutManager2);

        mtextViewadapter2 = new textViewAdpter(list, this);
        mrecyclerView2.setAdapter(mtextViewadapter2);

    }

    public void initDataHistory(List<TextViewModel> list) {
        mrecyclerView3 = findViewById(R.id.recyclerview3);
        mstaggeredGridLayoutManager3 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mstaggeredGridLayoutManager3.setOrientation(GridLayoutManager.VERTICAL);
        mrecyclerView3.setLayoutManager(mstaggeredGridLayoutManager3);
        mtextViewadapter3 = new textViewAdpter(list, this);
        mrecyclerView3.setAdapter(mtextViewadapter3);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        msearchPresenter.searchData(autoCompleteTextView.getText().toString());

    }

    /*public void initDataTop(List<TextViewModel> list){
        mrecyclerView=(RecyclerView)findViewById(R.id.recyclerview2);
        mgridLayoutManager=new GridLayoutManager(this,3);
        mrecyclerView.setLayoutManager(mgridLayoutManager);
        mtextViewadapter=new textViewAdpter(list,this);
        mrecyclerView.setAdapter(mtextViewadapter);
        Toast.makeText(SearchView.this,"123456",Toast.LENGTH_SHORT).show();

    }*/
}
