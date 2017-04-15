package com.example.wmschane.projectsample;

import android.app.Fragment;
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
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.example.wmschane.projectsample.dummy.AlertsContent;
import com.example.wmschane.projectsample.dummy.RoomContent;

import java.util.ArrayList;
import java.util.HashMap;

public class ProtectionActivity extends AppCompatActivity implements RoomFragment.OnListFragmentInteractionListener, AlertsFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Protection");

        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, new ProtectionFragment());
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
    public void onListFragmentInteraction(RoomContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(AlertsContent.DummyItem item) {

    }
}
