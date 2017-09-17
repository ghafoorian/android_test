package com.usertest.usertest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usertest.usertest.R;
import com.usertest.usertest.activities.DetailsActivity;
import com.usertest.usertest.holders.UsersHolder;
import com.usertest.usertest.models.UsersModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asma on 9/17/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    RecyclerView mRecyclerView;
    private HashMap<String, Integer> hashMap;
    private List<UsersModel> mUsersList = new ArrayList();
    Context mContext;
    FragmentActivity mActivity;
    private int lastPosition = -1;

    public UsersAdapter(FragmentActivity activity ,Context mContext) {
        this.mContext = mContext;
        this.mActivity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_users, parent, false);
        mRecyclerView = (RecyclerView) parent;
        hashMap = new HashMap<>();
        hashMap.put("name", R.id.user_name_txt);

        viewHolder = new UsersHolder(view, hashMap, mContext);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UsersModel mUsers;
        UsersHolder mUserHolder;

        mUsers = mUsersList.get(position);
        mUserHolder = (UsersHolder) holder;
        mUserHolder.fillList(mUsers);

        ItemOnClickListener itemOnClickListener;
        itemOnClickListener = new ItemOnClickListener(mUsers.getUserName(), mUsers.getUserId());
        mUserHolder.itemBody.setOnClickListener(itemOnClickListener);
    }

    @Override
    public int getItemCount() {
        if (mUsersList.size() == 0) {
            return 0;
        }
        return mUsersList.size() ;
    }

    public void setItems(List<UsersModel> listItems) {
        this.mUsersList = listItems;
        notifyDataSetChanged();
    }



    class ItemOnClickListener implements View.OnClickListener {


        private String mName;
        private String mId;

        public ItemOnClickListener(String name, String id) {

            this.mName = name;
            this.mId = id;

        }

        public void onClick(View v) {

            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.putExtra("name", mName);
            intent.putExtra("id", mId);
            mActivity.startActivity(intent);

        }
    }
}
