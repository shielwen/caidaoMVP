package com.example.administrator.caidaomvp.ActivityPresenter;

import com.example.administrator.caidaomvp.ActivityView.LoginView;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/5/8 0008.
 */

public class LoginPresenter implements LoginPresenterInterface {
    private LoginView loginview;

    public LoginPresenter(LoginView loginview) {
        this.loginview = loginview;
        //初始化数据
    }

    //登陆检查
    @Override
    public void loginCheck(String username, String password) {
        loginview.showProgressDialog();

        //网络请求
        HttpUtil.sendOkHttpRequest("", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loginview.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loginview.closeProgressDialog();
                        loginview.LoginResult(false, "怕不是网络出了问题");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responsedata = response.body().string();
                loginview.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responsedata != null) {
                            loginview.closeProgressDialog();
                            loginview.LoginResult(true, "0");
                        } else {
                            loginview.LoginResult(false, "菜道君的错误");
                        }
                    }
                });
            }
        });

    }


}
