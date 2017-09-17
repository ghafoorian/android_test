package com.usertest.usertest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.usertest.usertest.models.UsersInfoModel;
import com.usertest.usertest.models.UsersModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asma on 9/17/17.
 */

public class OpenDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 6;

    public OpenDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.execSQL(UsersTable.CREATE_USER_TABLE);

            sqLiteDatabase.execSQL(DetailsTable.CREATE_DETAILDS_TABLE);
            sqLiteDatabase.setTransactionSuccessful();
        }
        finally{
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsersTable.USER_TABLE );
        onCreate(sqLiteDatabase);
    }

    public void addUserToUserTabel(String name, String id){

        SQLiteDatabase sqLiteDatabase;

        ContentValues value = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        value.put(UsersTable.USER_ID, id);
        value.put(UsersTable.USER_NAME, name);
        db.insert(UsersTable.USER_TABLE, null, value);
        db.close();
    }


    public void addUserDetailsToUserTabel(String name, int id, String email, int age, String isFemal, String hobbies, String image, String back){

        SQLiteDatabase sqLiteDatabase;

        ContentValues value = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        value.put(DetailsTable.USER_ID, id);
        value.put(DetailsTable.USER_NAME, name);
        value.put(DetailsTable.USER_EMAIL, email);
        value.put(DetailsTable.USER_AGE, age);
        value.put(DetailsTable.USER_IS_FEMAL, isFemal);
        value.put(DetailsTable.USER_HOBBIES, hobbies);
        value.put(DetailsTable.USER_BACK, back);
        value.put(DetailsTable.USER_IMAGE, image);
        db.insert(DetailsTable.DETAILS_TABLE, null, value);
        db.close();
    }

    public List<UsersModel> getUsersList() {
        UsersModel usersModel;
        List<UsersModel> usersModelList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UsersTable.USER_TABLE, null);
        if (cursor != null && cursor.moveToFirst()) {

            do {

                usersModel = new UsersModel(cursor.getString(0), cursor.getString(1));
                // Log.d("username", cursor.getString(i));

                usersModelList.add(usersModel);
            } while (cursor.moveToNext());
        }
     return  usersModelList;
    }

    public UsersInfoModel getUserDetailsList(String id) {
        UsersInfoModel usersModel;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM " + DetailsTable.DETAILS_TABLE + " WHERE " + DetailsTable.USER_ID
                + " = ? " , new String[] {id});
        if (cursor != null && cursor.moveToFirst()) {

            usersModel = new UsersInfoModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(4),
                    cursor.getInt(3), cursor.getString(7), cursor.getString(5), cursor.getString(6));
            return  usersModel;
        }
        return  null;
    }
}
