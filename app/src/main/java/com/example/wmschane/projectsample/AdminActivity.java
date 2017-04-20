package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent != null){
            String title = intent.getStringExtra(MainActivity.TITLE);
            if (title != null){
                getSupportActionBar().setTitle(title);
            }
        }

        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, new AdminFragment());
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.admin_menu:
                Intent intent = new Intent(this, AdminActivity.class);
                intent.putExtra(MainActivity.TITLE, MainActivity.ADMIN);
                startActivity(intent);
                return true;
            case R.id.health_menu:
                intent = new Intent(this, HealthActivity.class);
                intent.putExtra(MainActivity.TITLE, MainActivity.HEALTH);
                startActivity(intent);
                return true;
            case R.id.energy_menu:
                intent = new Intent(this, EnergyActivity.class);
                intent.putExtra(MainActivity.TITLE, MainActivity.ENERGY);
                startActivity(intent);
                return true;
            case R.id.protection_menu:
                intent = new Intent(this, ProtectionActivity.class);
                intent.putExtra(MainActivity.TITLE, MainActivity.PROTECTION);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
