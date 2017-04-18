package com.example.wmschane.projectsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.CheckBox;

public class RoomLightsActivity extends AppCompatActivity {

    TextView roomName1;
    CheckBox roomCheck1;
    TextView roomName2;
    CheckBox roomCheck2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Light");
        setContentView(R.layout.fragment_lights);

        roomName1 = (TextView) findViewById(R.id.viewText1);
        roomCheck1 = (CheckBox) findViewById(R.id.checkBox1);
        roomName1.setText("Room 1");
        roomCheck1.setChecked(false);

        roomName2 = (TextView) findViewById(R.id.viewText2);
        roomCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        roomName2.setText("Room 2");
        roomCheck2.setChecked(true);
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
