package com.example.administrator.caidaomvp.ActivityPresenter;

import com.example.administrator.caidaomvp.ActivityView.SearchView;
import com.example.administrator.caidaomvp.Model.TextViewModel;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/5/15 0015.
 */

public class SearchPresenter {
    private SearchView searchView;


    private List<TextViewModel> list1;

    private List<TextViewModel> list2;
    private List<TextViewModel> list3;
    private List<TextViewModel> list4;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
    }

    public void initData() {
        HttpRequestHot();
        HttpRequestHistory();

    }

    public void searchData(String s) {
        if (s.equals("") || s == null) {
            list1.clear();
            TextViewModel textViewModel = new TextViewModel("暂时无此菜");
            list1.add(textViewModel);
            searchView.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    searchView.initDataTop(list1);
                }
            });
        } else {
            HttpRequestTop(s);
        }

    }

    public void HttpRequestTop(String s) {
        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchView.Result("网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final int i = response.code();
                final String responseData = response.body().string();
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list1 = HttpUtil.parseTextViewModel(responseData);
                        searchView.initDataTop(list1);
                    }
                });

            }
        });
    }

    public void HttpRequestHot() {
        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchView.Result("网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData != null) {
                            list2 = HttpUtil.parseTextViewModel(responseData);
                            searchView.initDataHot(list2);

                        } else {
                            searchView.Result("服务器暂停工作");
                        }
                    }
                });
            }
        });
    }

    public void HttpRequestHistory() {

        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchView.Result("网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                searchView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData != null) {
                            list3 = HttpUtil.parseTextViewModel(responseData);
                            searchView.initDataHistory(list3);

                        } else {
                            searchView.Result("服务器暂停工作");
                        }
                    }
                });
            }
        });
    }


}
