package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TemperaturesActivity extends AppCompatActivity implements TempFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Temp");
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_temperatures);
//        getSupportActionBar().setTitle("Temp");
//
//        Button addDate = (Button)findViewById(R.id.add_date_button);
//        addDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(TemperaturesActivity.this, SelectDateActivity.class));
//            }
//        });



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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
