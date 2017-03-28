package com.example.wmschane.projectsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Rodrigo on 3/14/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                startActivity(new Intent(this, AdminActivity.class));
                return true;
            case R.id.health_menu:
                startActivity(new Intent(this, HealthActivity.class));
                return true;
            case R.id.energy_menu:
                startActivity(new Intent(this, EnergyActivity.class));
                return true;
            case R.id.protection_menu:
                startActivity(new Intent(this, ProtectionActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
