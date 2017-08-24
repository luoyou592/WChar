package com.royal.wchar.presenter;

import com.royal.wchar.model.ContactListItem;

import java.util.List;


public interface ContactPresenter {

    void getContactsFromServer();

    List<ContactListItem> getContactList();

    void refreshContactList();

    void deleteFriend(String name);

}
