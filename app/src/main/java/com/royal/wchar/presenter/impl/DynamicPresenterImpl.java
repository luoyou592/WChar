package com.royal.wchar.presenter.impl;

import com.hyphenate.chat.EMClient;
import com.royal.wchar.adpater.EMCallBackAdapter;
import com.royal.wchar.presenter.DynamicPresenter;
import com.royal.wchar.utils.ThreadUtils;
import com.royal.wchar.view.DynamicView;

/**
 * 创建者:   Leon
 * 创建时间:  2016/10/18 10:18
 * 描述：    TODO
 */
public class DynamicPresenterImpl implements DynamicPresenter {

    private DynamicView mDynamicView;

    public DynamicPresenterImpl(DynamicView dynamicView) {
        mDynamicView = dynamicView;
    }

    @Override
    public void logout() {
        mDynamicView.onStartLogout();
        EMClient.getInstance().logout(true, mEMCallBackAdapter);
    }

    private EMCallBackAdapter mEMCallBackAdapter = new EMCallBackAdapter() {

        @Override
        public void onSuccess() {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mDynamicView.onLogoutSuccess();
                }
            });
        }

        @Override
        public void onError(int i, String s) {
            ThreadUtils.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mDynamicView.onLogoutFailed();
                }
            });
        }
    };
}
