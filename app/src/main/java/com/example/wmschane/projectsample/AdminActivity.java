package com.example.wmschane.projectsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Admin");
        setContentView(R.layout.activity_admin);
    }
}
