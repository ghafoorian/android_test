package com.usertest.usertest.sqlite;

/**
 * Created by asma on 9/17/17.
 */

public class DetailsTable {

    public static final String DETAILS_TABLE  = "details";
    public static final String USER_NAME    ="name";
    public static final String USER_ID = "_id";
    public static final String USER_EMAIL = "email";
    public static final String USER_AGE = "age";
    public static final String USER_IS_FEMAL = "is_femal";
    public static final String USER_IMAGE = "image";
    public static final String USER_BACK = "back";
    public static final String USER_HOBBIES = "hibbies";


    public static final String CREATE_DETAILDS_TABLE = "CREATE TABLE " + DETAILS_TABLE
            + "(" +
            USER_ID + " INTEGER , " +
            USER_NAME + " TEXT, " +
            USER_EMAIL + " TEXT, " +
            USER_AGE + " INTEGER, " +
            USER_IS_FEMAL + " TEXT, " +
            USER_IMAGE + " TEXT, " +
            USER_BACK + " TEXT, " +
            USER_HOBBIES + " TEXT " +
            ")";
}
