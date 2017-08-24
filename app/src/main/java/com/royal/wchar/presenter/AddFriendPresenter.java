package com.royal.wchar.presenter;

import com.royal.wchar.model.AddFriendItem;

import java.util.List;


public interface AddFriendPresenter {
    public static final String TAG = "AddFriendPresenter";

    void searchFriend(String keyword);

    void onDestroy();

    List<AddFriendItem> getAddFriendList();
}
