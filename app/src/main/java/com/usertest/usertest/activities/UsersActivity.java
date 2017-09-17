package com.usertest.usertest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.usertest.usertest.R;
import com.usertest.usertest.adapters.UsersAdapter;
import com.usertest.usertest.models.UsersModel;
import com.usertest.usertest.sqlite.OpenDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private RecyclerView mRecyclerView;
    private List<UsersModel> mUsersModel ;
    OpenDatabaseHelper mOpenDatabaseHelper;
    UsersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        InitializeViews();
        addUsersIntoDatabase();
        addDetailsIntoDatabase();

        mUsersModel = mOpenDatabaseHelper.getUsersList();

        for(UsersModel user : mUsersModel){
            Log.d("uers", user.getUserId() + user.getUserName());
        }
        mAdapter.setItems(mUsersModel);


    }

    public void InitializeViews(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView)findViewById(R.id.toolbar_title_txt);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mAdapter = new UsersAdapter(this, getBaseContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.deleteDatabase("mydb.db");
        mUsersModel = new ArrayList<>();
        mOpenDatabaseHelper = new OpenDatabaseHelper(this);



    }

    public void addUsersIntoDatabase(){
        mOpenDatabaseHelper.addUserToUserTabel("Mark", "1");
        mOpenDatabaseHelper.addUserToUserTabel("John", "2");
        mOpenDatabaseHelper.addUserToUserTabel("Anna", "5");
        mOpenDatabaseHelper.addUserToUserTabel("Ursula", "7");
        mOpenDatabaseHelper.addUserToUserTabel("Frank", "8");
        mOpenDatabaseHelper.addUserToUserTabel("Steward", "12");
        mOpenDatabaseHelper.addUserToUserTabel("Tyrone", "14");
        mOpenDatabaseHelper.addUserToUserTabel("Tara", "15");
        mOpenDatabaseHelper.addUserToUserTabel("Johan", "16");
        mOpenDatabaseHelper.addUserToUserTabel("Jamal", "20");
        mOpenDatabaseHelper.addUserToUserTabel("Arthur", "22");
        mOpenDatabaseHelper.addUserToUserTabel("Emilia", "26");
    }

    public void addDetailsIntoDatabase(){
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Mark", 1 , "mark@gmail.com", 20, "false", "Swimming", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("John", 2 , "john@gmail.com", 34, "false", "Swimming, Driving, Singing, Playing piano, making funny noises", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Anna", 5 , "anna@gmail.com", 21, "true", "not sure, probably sleeping", "http://lorempixel.com/output/people-q-c-200-200-1.jpg", "http://lorempixel.com/output/animals-q-c-600-200-9.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Ursula", 7 , "ursula@gmail.com", 31, "true", "talking, Walking", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/animals-q-c-600-200-4.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Frank", 8 , "frank@gmail.com", 40, "false", "talking", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/animals-q-c-600-200-4.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Steward", 12 , "steward@gmail.com", 49, "false", "Origami", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/animals-q-c-600-200-6.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Tyrone", 14 , "tyrone@gmail.com", 37, "false", "Fishing, hiking, creating figurines out of sticks and paper bags during the night", "http://lorempixel.com/output/people-q-c- 200-200-5.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Tara", 15 , "tara@gmail.com", 26, "true", "making bed", "http://lorempixel.com/output/people-q-c-200-200-6.jpg", "http://lorempixel.com/output/animals-q-c-600-200-7.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Johan", 16 , "johan@gmail.com", 23, "false", "hiking", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Jamal", 20 , "jamal@gmail.com", 24, "false", "Playing piano", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Arthur", 22 , "arthur@gmail.com", 25, "false", "Driving", "lorempixel.com/output/people-q-c-200-200-7", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");
        mOpenDatabaseHelper.addUserDetailsToUserTabel("Emilia", 26 , "emilia@gmail.com", 27, "true", "making funny noises", "http://lorempixel.com/output/people-q-c-200-200-2.jpg", "http://lorempixel.com/output/people-q-c-200-200-2.jpg");




    }

}
