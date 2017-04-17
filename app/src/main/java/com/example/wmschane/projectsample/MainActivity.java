package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.wmschane.projectsample.dummy.AlertsContent;
import com.example.wmschane.projectsample.dummy.RoomContent;

/**
 * Created by Rodrigo on 3/14/2017.
 */

public class MainActivity extends AppCompatActivity
    implements AlertsFragment.OnListFragmentInteractionListener, RoomFragment.OnListFragmentInteractionListener {

    ProtectionDatabase pd;
    TempDatabase td;
    AppliancesDatabase ad;
    EnergyDatabase ed;
    MainDataBase md;
    DBHelper db; // is the sample class working right?




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProtectionDatabase(getApplicationContext());
        td= new TempDatabase(getApplicationContext());
        ad = new AppliancesDatabase(getApplicationContext());
        ed = new EnergyDatabase(getApplicationContext());
        md = new MainDataBase(getApplicationContext());

        db = new DBHelper(getApplicationContext());
        db.updateSetting("laundry", true, "1");
        Log.d("logbase", "Data "+ db.getSettings("laundry"));

        boolean DaySet = td.updateSetting("Sunday","70","70");
        DaySet = td.updateSetting("Monday","70","70");
        DaySet = td.updateSetting("Tuesday","70","70");
        DaySet = td.updateSetting("Wednesday","70","70");
        DaySet = td.updateSetting("Thursday","70","70");
        DaySet = td.updateSetting("Friday","70","70");
        DaySet = td.updateSetting("Saturday","70","70");

        boolean LightSet;
        for(int i = 1; i < 15; i++){
            LightSet = ed.updateSetting("Room "+ i,"off");
            Log.d("tag", "Boolean DB LightSet " + LightSet);
        }


        boolean ProtectionSet;
        for(int i = 1; i < 15; i++){
            ProtectionSet = pd.updateSetting("Area "+ i,"off");
            Log.d("tag", "Boolean DB ProtectionSet " + ProtectionSet);
        }

        boolean ApplSet;
        for(int i = 1; i < 15; i++){
            ApplSet = ad.updateSetting("Appliance "+ i,"off");
            Log.d("tag", "Boolean DB ApplSet " + ApplSet);
        }

        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        SharedPreferences preferences = getSharedPreferences("authentic", MODE_PRIVATE);
        if(preferences.getBoolean("authentic", true)){ // TODO change default to false after implementation of login

            transaction.replace(R.id.mainFrame, new AlertsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
//        getSupportActionBar().setTitle("Home");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        FragmentTransaction transaction;
//        transaction = getFragmentManager().beginTransaction();
//        transaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
        switch (item.getItemId()) {
            case R.id.admin_menu:
//                transaction.replace(R.id.mainFrame, new AdminFragment());
//                transaction.commit();
                startActivity(new Intent(this, AdminActivity.class));
                return true;
            case R.id.health_menu:
//                Toast.makeText(this, "Nope Health", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HealthActivity.class));
                return true;
            case R.id.energy_menu:
//                transaction.replace(R.id.mainFrame, new EnergyFragment());
//                transaction.commit();
                startActivity(new Intent(this, EnergyActivity.class));
                return true;
            case R.id.protection_menu:
//                transaction.replace(R.id.mainFrame, new ProtectionFragment());
//                transaction.commit();
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
