package com.royal.wchar.event;

/**
 * 创建者:   luoyou
 * 创建时间:  2017/8/19 17:09
 * 描述：    TODO
 */
public class AddFriendEvent {
    public static final String TAG = "AddFriendEvent";

    private String mFriendName;

    private String mReason;

    public AddFriendEvent(String friendName, String reason) {
        this.mFriendName = friendName;
        this.mReason = reason;
    }


    public String getFriendName() {
        return mFriendName;
    }

    public void setFriendName(String friendName) {
        this.mFriendName = friendName;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String reason) {
        this.mReason = reason;
    }
}
