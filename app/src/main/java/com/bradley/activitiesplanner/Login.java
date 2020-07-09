package com.bradley.activitiesplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button loginButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        mEmail = (EditText) findViewById(R.id.login_email);
        mPassword = (EditText) findViewById(R.id.login_password);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                Boolean validateLoginDetails = db.loginDetails(email, password);
                if(email.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter your email", Toast.LENGTH_LONG).show();
                }
                else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your password", Toast.LENGTH_LONG).show();
                }
                else if(validateLoginDetails == true) {
                    Toast.makeText(getApplicationContext(), "Logged in successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, UserProfile.class);
                    intent.putExtra(UserProfile.EMAIL, email);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(), "Email or Password incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void signUp(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}