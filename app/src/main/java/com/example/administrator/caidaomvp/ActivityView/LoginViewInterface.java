package com.example.administrator.caidaomvp.ActivityView;


public interface LoginViewInterface {
    public void LoginResult(boolean ret, String code);

    public void showProgressDialog();

    public void closeProgressDialog();
}
