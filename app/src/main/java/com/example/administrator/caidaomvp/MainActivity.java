package com.example.administrator.caidaomvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.caidaomvp.ActivityView.HomeView;
import com.example.administrator.caidaomvp.ActivityView.LoginView;
import com.example.administrator.caidaomvp.ActivityView.VideoViews;
import com.example.administrator.caidaomvp.Demo.text;

//1、设置焦点
public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildId();
    }

    //1、设置焦点
    private void buildId() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, text.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeView.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VideoViews.class));
            }
        });
    }

}
