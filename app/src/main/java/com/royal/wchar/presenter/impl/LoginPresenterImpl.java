package com.royal.wchar.presenter.impl;

import com.hyphenate.chat.EMClient;
import com.royal.wchar.adpater.EMCallBackAdapter;
import com.royal.wchar.presenter.LoginPresenter;
import com.royal.wchar.utils.StringUtils;
import com.royal.wchar.utils.ThreadUtils;
import com.royal.wchar.view.LoginView;

/**
 * 创建者:   Leon
 * 创建时间:  2016/10/16 21:17
 * 描述：    TODO
 */
public class LoginPresenterImpl implements LoginPresenter {
    public static final String TAG = "LoginPresenterImpl";


    public LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
    }

    @Override
    public void login(String userName, String pwd) {
        if (StringUtils.checkUserName(userName)) {
            if (StringUtils.checkPassword(pwd)) {
                mLoginView.onStartLogin();
                startLogin(userName, pwd);
            } else {
                mLoginView.onPasswordError();
            }
        } else {
            mLoginView.onUserNameError();
        }
    }

    private void startLogin(String userName, String pwd) {
        EMClient.getInstance().login(userName, pwd, mEMCallBack);
    }

    private EMCallBackAdapter mEMCallBack = new EMCallBackAdapter() {

        @Override
        public void onSuccess() {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoginView.onLoginSuccess();
                }
            });
        }

        @Override
        public void onError(int i, String s) {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoginView.onLoginFailed();
                }
            });
        }
    };
}
