package com.usertest.usertest.holders;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.usertest.usertest.R;
import com.usertest.usertest.models.UsersModel;

import java.util.HashMap;

/**
 * Created by asma on 9/17/17.
 */

public class UsersHolder extends RecyclerView.ViewHolder{

    private TextView mUserName;

    private HashMap<String,Integer> mHashMap;
    Context mContext;
    public View itemBody;

    public UsersHolder(final View itemView, HashMap<String, Integer> itemHashMap, Context context) {
        super(itemView);

        mHashMap = itemHashMap;
        mUserName = (TextView)itemView.findViewById(getId("name"));
        itemBody = (View) itemView.findViewById(R.id.item_body);
    }

    public void fillList(UsersModel currentItem){
        mUserName.setText(currentItem.getUserName());

    }

    private int getId(String key){
        Object result = mHashMap.get(key);
        if((int) result == 0) {
            return 0;
        }
        return (int) result;
    }
}
