package com.example.wmschane.projectsample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity  {

    private DBHelper db;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        db = new DBHelper(getApplicationContext());

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                String email = mEmailView.getText().toString();
                String pass = mPasswordView.getText().toString();

                if(isEmailValid(email) && isPasswordValid(pass)){
                    attemptLogin(pass, email);
                }else if(!isEmailValid(email)){
                    Toast.makeText(LoginActivity.this, "Enter user info", Toast.LENGTH_SHORT).show();
                }else if(!isPasswordValid(pass)){
                    Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void attemptLogin(String Pass, String Name) {

        ArrayList<HashMap<String, Object>> data = db.getLoginSettings("Shawn","Rodrigo");

        SharedPreferences preferences = getSharedPreferences("authentic", MODE_PRIVATE);

        Log.d("logindb", "DB data:\n" + data.get(0).toString() + "\n" + data.get(0).get(DBHelper.PK_COLUMN_USERNAME));
        String s = data.get(0).get(DBHelper.PK_COLUMN_USERNAME).toString();
        String p = data.get(0).get(DBHelper.COLUMN_PASSWORD).toString();

        if (Name.equals(s) && Pass.equals(p)){
            preferences.edit().putBoolean("authentic", true).apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(this, "Invalid login info", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.length() > 0;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 0;
    }

}

