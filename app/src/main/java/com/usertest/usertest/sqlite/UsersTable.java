package com.usertest.usertest.sqlite;

/**
 * Created by asma on 9/17/17.
 */

public class UsersTable {

    public static final String USER_TABLE  = "users";
    public static final String USER_NAME    ="name";
    public static final String USER_ID = "_id";



    public static final String CREATE_USER_TABLE="CREATE TABLE " + USER_TABLE
            + "(" +
            USER_ID + " Text , " +
            USER_NAME + " TEXT " +

            ")";
}
