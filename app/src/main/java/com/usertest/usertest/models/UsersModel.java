package com.usertest.usertest.models;

/**
 * Created by asma on 9/17/17.
 */

public class UsersModel {

    String UserId;
    String UserName;

    public UsersModel(String userId, String userName){

        this.UserId = userId;
        this.UserName = userName;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
