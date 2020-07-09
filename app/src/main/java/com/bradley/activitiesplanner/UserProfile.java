package com.bradley.activitiesplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {
    public static final String EMAIL = "com.jwhh.jim.notekeeper.EMAIL";
    private TextView mTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mTextEmail = (TextView) findViewById(R.id.user_profile_email);
        String email = getIntent().getStringExtra(EMAIL).toString();
        mTextEmail.setText("Welcome: " + email);

    }


    public void logOut(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}