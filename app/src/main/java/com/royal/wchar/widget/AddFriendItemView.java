package com.royal.wchar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.royal.wchar.R;
import com.royal.wchar.event.AddFriendEvent;
import com.royal.wchar.model.AddFriendItem;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class AddFriendItemView extends RelativeLayout {
    public static final String TAG = "AddFriendItemView";
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.timestamp)
    TextView mTimestamp;
    @BindView(R.id.add)
    Button mAdd;


    public AddFriendItemView(Context context) {
        this(context, null);
    }

    public AddFriendItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_add_friend_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AddFriendItem addFriendItem) {
        mUserName.setText(addFriendItem.userName);
        mTimestamp.setText(addFriendItem.timestamp);
        if (addFriendItem.isAdded) {
            mAdd.setText(getContext().getString(R.string.added));
            mAdd.setEnabled(false);
        } else {
            mAdd.setText(getContext().getString(R.string.add));
            mAdd.setEnabled(true);
        }
    }

    @OnClick(R.id.add)
    public void onClick() {
        String friendName = mUserName.getText().toString().trim();
        String addFriendReason = getContext().getString(R.string.add_friend_reason);
        AddFriendEvent event = new AddFriendEvent(friendName, addFriendReason);
        EventBus.getDefault().post(event);
    }

}
