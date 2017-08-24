package com.royal.wchar.view;



public interface RegisterView {

    void onStartRegister();

    void onRegisterError();

    void onResisterUserExist();

    void onRegisterSuccess();

    void onUserNameError();

    void onPasswordError();

    void onConfirmPasswordError();

}
