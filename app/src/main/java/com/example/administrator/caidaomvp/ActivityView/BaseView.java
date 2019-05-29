package com.example.administrator.caidaomvp.ActivityView;

public interface BaseView {
    public void initData();//初始化数据
    public void initID();//获取id
    public void Result(String code);//Presenter处理结果弹出Toast
}
