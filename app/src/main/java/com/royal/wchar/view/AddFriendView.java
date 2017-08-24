package com.royal.wchar.view;


public interface AddFriendView {
    public static final String TAG = "AddFriendView";

    void onStartSearch();

    void onSearchSuccess();

    void onSearchFailed();

    void onAddFriendSuccess();

    void onAddFriendFailed();
}
