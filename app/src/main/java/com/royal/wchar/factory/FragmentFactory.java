package com.royal.wchar.factory;

import com.royal.wchar.R;
import com.royal.wchar.ui.fragment.BaseFragment;
import com.royal.wchar.ui.fragment.ContactFragment;
import com.royal.wchar.ui.fragment.ConversationFragment;
import com.royal.wchar.ui.fragment.DynamicFragment;

/**
 * 创建者:   luoyou
 * 创建时间:  2017/8/19 18:26
 * 描述：    TODO
 */
public class FragmentFactory {
    public static final String TAG = "FragmentFactory";

    private static FragmentFactory sFragmentFactory;

    private BaseFragment mMessageFragment;
    private BaseFragment mContactFragment;
    private BaseFragment mDynamicFragment;

    public static FragmentFactory getInstance() {
        if (sFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (sFragmentFactory == null) {
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    public BaseFragment getFragment(int id) {
        switch (id) {
            case R.id.conversations:
                return getConversationFragment();
            case R.id.contacts:
                return getContactFragment();
            case R.id.dynamic:
                return getDynamicFragment();
        }
        return null;
    }

    private BaseFragment getConversationFragment() {
        if (mMessageFragment == null) {
            mMessageFragment = new ConversationFragment();
        }
        return mMessageFragment;
    }

    private BaseFragment getDynamicFragment() {
        if (mDynamicFragment == null) {
            mDynamicFragment = new DynamicFragment();
        }
        return mDynamicFragment;
    }

    private BaseFragment getContactFragment() {
        if (mContactFragment == null) {
            mContactFragment = new ContactFragment();
        }
        return mContactFragment;
    }




}
