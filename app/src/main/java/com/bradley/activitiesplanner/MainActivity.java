package com.bradley.activitiesplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mFullname, mPassword, mEmail;
    Button mRegisterButton, signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        mFullname = (EditText) findViewById(R.id.edit_text_fullname);
        mPassword = (EditText) findViewById(R.id.edit_text_password);
        mEmail = (EditText) findViewById(R.id.edit_text_email);
        mRegisterButton = (Button) findViewById(R.id.button_sign_up);
        signIn = (Button) findViewById(R.id.sign_in);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = mFullname.getText().toString();
                String password = mPassword.getText().toString();
                String email = mEmail.getText().toString();

                if(fullName.equals("") || password.equals("") || email.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkMail = db.checkEmail(email);
                    if(checkMail == true) {
                        Boolean insert = db.insert(fullName, password, email);
                        if(insert == true)
                            Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    public void signIn(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}