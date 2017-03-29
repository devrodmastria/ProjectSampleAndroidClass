package com.example.wmschane.projectsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class EnergyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        Button manageLights = (Button)findViewById(R.id.manage_lights_button);
        manageLights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnergyActivity.this, RoomLightsActivity.class));
            }
        });

        Button tempBtn = (Button)findViewById(R.id.set_temperature_button);
        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnergyActivity.this, TemperaturesActivity.class));
            }
        });

        Button appliancesBtn = (Button)findViewById(R.id.manage_appliances_button);
        appliancesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnergyActivity.this, AppliancesActivity.class));
            }
        });
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
