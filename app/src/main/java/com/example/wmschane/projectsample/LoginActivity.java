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

    MainDataBase MB;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        MB = new MainDataBase(getApplicationContext());
        boolean res = MB.updateSetting("Shawn","Rodrigo");

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

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin(String Pass, String Name) {

        ArrayList<HashMap<String, Object>> data = MB.getSettings("Shawn","Rodrigo");

        SharedPreferences preferences = getSharedPreferences("authentic", MODE_PRIVATE);

        Log.d("logindb", "DB data:\n" + data.get(0).toString() + "\n" + data.get(0).get("UserName"));
        String s = data.get(0).get("UserName").toString();
        String p = data.get(0).get("Password").toString();

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

