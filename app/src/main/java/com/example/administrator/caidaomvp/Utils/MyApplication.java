package com.example.administrator.caidaomvp.Utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2019/4/29 0029.
 */


//可以获得全局 context
public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }


}
