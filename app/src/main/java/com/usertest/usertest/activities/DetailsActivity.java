package com.usertest.usertest.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.usertest.usertest.R;
import com.usertest.usertest.models.UsersInfoModel;
import com.usertest.usertest.sqlite.OpenDatabaseHelper;
import android.support.v4.widget.*;

import de.hdodenhof.circleimageview.*;

/**
 * Created by asma on 9/17/17.
 */

public class DetailsActivity extends AppCompatActivity{

    private TextView mEmail, mAge, mGender, mHobbies;
    private ImageView mImage;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private Toolbar mToolbar;
    private Button mSendEmail;
    private CircleImageView mBackImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        InitializedViews();
        Intent intent = getIntent();

        OpenDatabaseHelper mOpenDatabase = new OpenDatabaseHelper(this);
        final UsersInfoModel mUserInfo = mOpenDatabase.getUserDetailsList(intent.getStringExtra("id"));
        mEmail.setText(mUserInfo.getEmail());

        Picasso.with(this)
                .load(mUserInfo.getImage())
                .into(mImage);
        Picasso.with(this)
                .load(mUserInfo.getBack())
                .into(mBackImage);

        mAge.setText("" + mUserInfo.getAge());
        mGender.setText(mUserInfo.getIsFemal().matches("false")? "Male" : "Female");
        mHobbies.setText(mUserInfo.getHobbies());

        setupToolbar(mToolbar, mUserInfo.getName());

        mSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+mUserInfo.getEmail()));
                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available
                }

            }
        });
    }

    public void InitializedViews(){
        mEmail = (TextView)findViewById(R.id.email);
        mAge = (TextView)findViewById(R.id.age);
        mGender = (TextView)findViewById(R.id.gender);
        mHobbies = (TextView)findViewById(R.id.hobbies);
        mImage = (ImageView)findViewById(R.id.backdrop);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mSendEmail = (Button)findViewById(R.id.send_mail_btn);
        mBackImage = (CircleImageView)findViewById(R.id.back_image);
    }

    private void setupToolbar(Toolbar toolbar, String title) {

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(title);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.back_icon);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
