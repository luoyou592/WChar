package com.royal.wchar.view;


public interface LoginView {
    public static final String TAG = "LoginView";

    void onUserNameError();

    void onPasswordError();

    void onStartLogin();

    void onLoginSuccess();

    void onLoginFailed();


}
