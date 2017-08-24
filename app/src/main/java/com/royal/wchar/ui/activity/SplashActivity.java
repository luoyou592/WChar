package com.royal.wchar.ui.activity;


import com.royal.wchar.R;
import com.royal.wchar.presenter.SplashPresenter;
import com.royal.wchar.presenter.impl.SplashPresenterImpl;
import com.royal.wchar.view.SplashView;



public class SplashActivity extends BaseActivity implements SplashView {
    public static final String TAG = "SplashActivity";

    private static final int DELAY = 2000;

    private SplashPresenter mSplashPresenter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        super.init();
        mSplashPresenter = new SplashPresenterImpl(this);
        mSplashPresenter.checkLoginStatus();
    }

    @Override
    public void onNotLogin() {
        postDelay(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginActivity.class);
            }
        }, DELAY);
    }

    @Override
    public void onLoggedIn() {
        startActivity(MainActivity.class);
    }
}
