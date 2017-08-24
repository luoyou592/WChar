package com.royal.wchar.model;

import com.royal.wchar.R;



/**
 * 创建者:   luoyou
 * 创建时间:  2017/8/17 21:09
 * 描述：    TODO
 */
public class ContactListItem {
    public static final String TAG = "ContactListItem";

    public int avatar = R.mipmap.avatar6;

    public String userName;

    public boolean showFirstLetter = true;

    public char getFirstLetter() {
        return userName.charAt(0);
    }

    public String getFirstLetterString() {
        return String.valueOf(getFirstLetter()).toUpperCase();
    }
}
