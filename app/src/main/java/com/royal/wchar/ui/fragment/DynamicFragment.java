package com.royal.wchar.ui.fragment;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMClient;
import com.royal.wchar.R;
import com.royal.wchar.presenter.DynamicPresenter;
import com.royal.wchar.presenter.impl.DynamicPresenterImpl;
import com.royal.wchar.ui.activity.LoginActivity;
import com.royal.wchar.view.DynamicView;

import butterknife.BindView;
import butterknife.OnClick;


public class DynamicFragment extends BaseFragment implements DynamicView {
    public static final String TAG = "DynamicFragment";

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.logout)
    Button mLogout;
    @BindView(R.id.back)
    ImageView mBack;

    private DynamicPresenter mDynamicPresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void init() {
        super.init();
        mDynamicPresenter = new DynamicPresenterImpl(this);
        String logout = String.format(getString(R.string.logout), EMClient.getInstance().getCurrentUser());
        mLogout.setText(logout);
        mTitle.setText(getString(R.string.dynamic));

    }

    @OnClick(R.id.logout)
    public void onClick() {
        mDynamicPresenter.logout();
    }

    @Override
    public void onStartLogout() {
        showProgress(getString(R.string.logouting));
    }

    @Override
    public void onLogoutSuccess() {
        hideProgress();
        toast(getString(R.string.logout_success));
        startActivity(LoginActivity.class, true);
    }

    @Override
    public void onLogoutFailed() {
        hideProgress();
        toast(getString(R.string.logout_failed));
    }
}
