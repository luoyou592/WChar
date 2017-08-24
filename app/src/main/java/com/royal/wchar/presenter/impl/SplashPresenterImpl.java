package com.royal.wchar.presenter.impl;

import com.hyphenate.chat.EMClient;
import com.royal.wchar.presenter.SplashPresenter;
import com.royal.wchar.view.SplashView;

/**
 * 创建者:   Leon
 * 创建时间:  2016/10/16 19:14
 * 描述：    TODO
 */
public class SplashPresenterImpl implements SplashPresenter {
    public static final String TAG = "SplashPresenterImpl";

    public SplashView mSplashView;

    public SplashPresenterImpl(SplashView splashView) {
        mSplashView = splashView;
    }

    @Override
    public void checkLoginStatus() {
        if (EMClient.getInstance().isLoggedInBefore() && EMClient.getInstance().isConnected()) {
            mSplashView.onLoggedIn();
        } else {
            mSplashView.onNotLogin();
        }
    }
}
