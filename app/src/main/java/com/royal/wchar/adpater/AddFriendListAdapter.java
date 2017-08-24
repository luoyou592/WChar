package com.royal.wchar.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.royal.wchar.model.AddFriendItem;
import com.royal.wchar.widget.AddFriendItemView;

import java.util.List;

/**
 * 创建者:   luoyou
 * 创建时间:  2017/8/19 16:09
 * 描述：    TODO
 */
public class AddFriendListAdapter extends RecyclerView.Adapter<AddFriendListAdapter.AddFriendItemViewHolder> {

    private Context mContext;
    private List<AddFriendItem> mAddFriendItemList;

    public AddFriendListAdapter(Context context, List<AddFriendItem> list) {
        mContext = context;
        mAddFriendItemList = list;
    }

    @Override
    public AddFriendItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AddFriendItemViewHolder(new AddFriendItemView(mContext));
    }

    @Override
    public void onBindViewHolder(AddFriendItemViewHolder holder, int position) {
        holder.mAddFriendItemView.bindView(mAddFriendItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAddFriendItemList.size();
    }


    public class AddFriendItemViewHolder extends RecyclerView.ViewHolder {

        public AddFriendItemView mAddFriendItemView;

        public AddFriendItemViewHolder(AddFriendItemView itemView) {
            super(itemView);
            mAddFriendItemView = itemView;
        }
    }
}
