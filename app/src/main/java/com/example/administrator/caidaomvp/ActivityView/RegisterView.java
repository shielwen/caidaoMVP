package com.example.administrator.caidaomvp.ActivityView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.caidaomvp.ActivityPresenter.RegisterPresenter;
import com.example.administrator.caidaomvp.R;

public class RegisterView extends AppCompatActivity implements RegisterViewInterface {
    private ProgressDialog mprogressDialog;
    private Button button1;
    private TextView textView1;
    private EditText editText1, editText2, editText3, editText4;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        registerPresenter = new RegisterPresenter(this);
        initView();
    }

    private void initView() {
        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        editText3 = (EditText) findViewById(R.id.edittext3);
        editText4 = (EditText) findViewById(R.id.edittext4);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPresenter.Register(editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString());
            }
        });

        textView1 = (TextView) findViewById(R.id.top_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void RegisterResult(Boolean result, String code) {
        if (result) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "注册失败:" + code, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void showProgressDialog() {
        if (mprogressDialog == null) {
            mprogressDialog = new ProgressDialog(this);
            mprogressDialog.setMessage("正在注册");
            mprogressDialog.setCanceledOnTouchOutside(false);
        }
        mprogressDialog.show();
    }

    /*
        关闭对话框
     */
    @Override
    public void closeProgressDialog() {
        if (mprogressDialog != null) {
            mprogressDialog.dismiss();
        }
    }
}
