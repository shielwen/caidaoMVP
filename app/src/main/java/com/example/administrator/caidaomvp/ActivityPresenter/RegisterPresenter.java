package com.example.administrator.caidaomvp.ActivityPresenter;

import com.example.administrator.caidaomvp.ActivityView.RegisterView;
import com.example.administrator.caidaomvp.WebHttp.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/5/13 0013.
 */

public class RegisterPresenter implements RegisterPresenterInterface {
    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void Register(String username, String password, String question, String answer) {

        registerView.showProgressDialog();
        HttpUtil.sendOkHttpRequest("", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                registerView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        registerView.closeProgressDialog();
                        registerView.RegisterResult(false, "网络连接失败");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                registerView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        registerView.closeProgressDialog();
                        registerView.RegisterResult(false, "网络连接ok");
                    }
                });


            }
        });
    }
}
