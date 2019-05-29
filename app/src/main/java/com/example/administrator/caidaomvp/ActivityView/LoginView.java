package com.example.administrator.caidaomvp.ActivityView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.caidaomvp.ActivityPresenter.LoginPresenter;
import com.example.administrator.caidaomvp.R;

public class LoginView extends AppCompatActivity implements LoginViewInterface, View.OnClickListener {
    private ProgressDialog mprogressDialog;
    private EditText editText1, editText2;
    private Button button1, button2;
    private TextView toptextview1, toptextview3;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        initView();
        //调用逻辑层
        loginPresenter = new LoginPresenter(this);
    }

    //初始化空件
    private void initView() {
        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        toptextview1 = (TextView) findViewById(R.id.top_textview1);
        toptextview1.setOnClickListener(this);
        toptextview3 = (TextView) findViewById(R.id.top_textview3);
        toptextview3.setOnClickListener(this);
    }

    //登陆结果
    @Override
    public void LoginResult(boolean ret, String code) {
        if (ret) {
            Toast.makeText(this, "登陆成功" + code, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登陆失败:" + code, Toast.LENGTH_SHORT).show();
        }
    }

    //弹窗
    @Override
    public void showProgressDialog() {
        if (mprogressDialog == null) {
            mprogressDialog = new ProgressDialog(this);
            mprogressDialog.setMessage("正在登陆");
            mprogressDialog.setCanceledOnTouchOutside(false);
        }
        mprogressDialog.show();
    }

    //关闭弹窗
    @Override
    public void closeProgressDialog() {
        if (mprogressDialog != null) {
            mprogressDialog.dismiss();
        }
    }

    //点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, RegisterView.class));
                break;
            case R.id.button2:
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                if (username.equals("") || password.equals("") || username == null || password == null) {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    loginPresenter.loginCheck(username, password);
                }
                break;
            case R.id.top_textview1:
                finish();
                break;
            case R.id.top_textview3:
                startActivity(new Intent(this, Retrievepassword.class));
                break;
        }
    }
}
