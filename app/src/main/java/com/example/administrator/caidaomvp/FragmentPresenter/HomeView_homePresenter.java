package com.example.administrator.caidaomvp.FragmentPresenter;

import com.example.administrator.caidaomvp.FragmentView.HomeView_home;
import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/5/14 0014.
 */

public class HomeView_homePresenter {
    private HomeView_home homeView_home;
    private List<NameModel> list;

    public HomeView_homePresenter(HomeView_home homeView_home) {
        this.homeView_home = homeView_home;
    }

    //初始化所有数据
    public void initData() {
        HttpRequestTop();
        HttpRequestMiddle();
    }


    //轮播图
    public void HttpRequestTop() {
        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeView_home.initDateTopResult(false, "网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData != null) {
                            List<NameModel> list = HttpUtil.parseNameModel(responseData);
                            homeView_home.initDateTopResult(true, "轮播图" + list.get(2).getName());
                            initdataTop(list);

                        } else {
                            homeView_home.initDateTopResult(false, "服务器暂停工作");
                        }
                    }
                });

            }
        });
    }

    //分配数据 图片和标题
    public void initdataTop(List<NameModel> list) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(HttpUtil.ip + "/img/" + list.get(i).getName() + ".jpg");
            list2.add(list.get(i).getName());
        }
        homeView_home.initDataTop(list1, list2);
    }


    //卡片布局
    public void HttpRequestMiddle() {
        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeView_home.initDateTopResult(false, "网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData != null) {
                            list = HttpUtil.parseNameModel(responseData);

                            NameModel nameModel1 = new NameModel();
                            nameModel1.setName("菜道");
                            NameModel nameModel2 = new NameModel();
                            nameModel2.setName("点我可以刷新");
                            list.add(nameModel1);
                            list.add(nameModel2);
                            homeView_home.initDataMiddle(list);

                        } else {
                            homeView_home.initDateTopResult(false, "服务器暂停工作");
                        }
                    }
                });

            }
        });
    }

    //卡片布局刷新
    public void HttpRequestMiddleRefresh() {
        HttpUtil.sendOkHttpRequest("androidHomeTop", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeView_home.initDateTopResult(false, "网络问题");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                homeView_home.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseData != null) {
                            List<NameModel> lists = HttpUtil.parseNameModel(responseData);
                            homeView_home.initDateTopResult(true, "已刷新" + lists.size() + "项内容");
                            addListRefresh(lists);
                            homeView_home.initDataMiddle(list);

                        } else {
                            homeView_home.initDateTopResult(false, "服务器暂停工作");
                        }
                    }
                });

            }
        });
    }

    //将刷新的内容加入进去
    private void addListRefresh(List<NameModel> lists) {
        NameModel nameModel1 = new NameModel();
        nameModel1.setName("你刚刚看到了这里");
        NameModel nameModel2 = new NameModel();
        nameModel2.setName("点我可以刷新");
        list.add(0, nameModel2);
        list.add(0, nameModel1);
        list.addAll(0, lists);
    }

}
