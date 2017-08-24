package com.royal.wchar.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.royal.wchar.model.ContactListItem;
import com.royal.wchar.widget.ContactListItemView;

import java.util.List;

/**
 * 创建者:   luoyou
 * 创建时间:  2017/8/19 12:09
 * 描述：    TODO
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactItemViewHolder> {
    public static final String TAG = "ContactListAdapter";

    private Context mContext;
    private List<ContactListItem> mContactListItems;
    private OnItemClickListener mOnItemClickListener;

    public ContactListAdapter(Context context, List<ContactListItem> items) {
        mContext = context;
        mContactListItems = items;
    }

    @Override
    public ContactItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactListItemView itemView = new ContactListItemView(mContext);
        return new ContactItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactItemViewHolder holder, int position) {
        final ContactListItem item = mContactListItems.get(position);
        holder.mItemView.bindView(item);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(item.userName);
                }
            }
        });
        holder.mItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemLongClick(item.userName);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mContactListItems == null) {
            return 0;
        }
        return mContactListItems.size();
    }

    public class ContactItemViewHolder extends RecyclerView.ViewHolder {

        public ContactListItemView mItemView;

        public ContactItemViewHolder(ContactListItemView itemView) {
            super(itemView);
            mItemView = itemView;
        }
    }

    public List<ContactListItem> getContactListItems() {
        return mContactListItems;
    }


    public interface OnItemClickListener {
        void onItemClick(String name);
        void onItemLongClick(String name);
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }
}
