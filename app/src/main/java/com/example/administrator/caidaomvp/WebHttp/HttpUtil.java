package com.example.administrator.caidaomvp.WebHttp;

import android.widget.Toast;

import com.example.administrator.caidaomvp.Model.NameModel;
import com.example.administrator.caidaomvp.Model.TextViewModel;
import com.example.administrator.caidaomvp.Utils.MyApplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by Administrator on 2019/4/3 0003.
 */

public class HttpUtil {
    public static String ip = "http://10.128.39.234:8080/caidao/";

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        address = ip + address;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

    /*
        解析json数据，并且 返回一个 list
     */
    public static List parseNameModel(String jsonData) {

        try {
            List<NameModel> list = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                NameModel nameModel = new NameModel();
                nameModel.setName(name);
                list.add(nameModel);
            }
            return list;

        } catch (Exception e) {
            Toast.makeText(MyApplication.getContext(), "false", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public static List parseTextViewModel(String jsonData) {

        try {
            List<TextViewModel> list = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                TextViewModel nameModel = new TextViewModel();
                nameModel.setName(name);
                list.add(nameModel);
            }
            return list;

        } catch (Exception e) {
            Toast.makeText(MyApplication.getContext(), "false", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
