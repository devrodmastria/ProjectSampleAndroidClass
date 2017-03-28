package com.example.wmschane.projectsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
