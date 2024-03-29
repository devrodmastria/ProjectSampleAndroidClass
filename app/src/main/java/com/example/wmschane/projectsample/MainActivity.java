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

/**
 * Created by Rodrigo on 3/14/2017.
 */

public class MainActivity extends AppCompatActivity
    implements AlertsFragment.OnListFragmentInteractionListener{

    DBHelper db;
    public  static final String TITLE = "title";
    public  static final String ADMIN = "Adm";
    public  static final String ENERGY = "Ene";
    public  static final String HEALTH = "Hea";
    public  static final String PROTECTION = "Pro";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("HC"); //HC is Home Control

        db = new DBHelper(getApplicationContext());

        boolean Setting;

        if(db.numberOfRowsLogin() == 0) {
            db.insertLoginSetting("Shawn","Rodrigo");
        }

        if(db.numberOfRowsEnergy() == 0){
            for(int i = 1; i < 15; i++){
                Setting = db.insertEnergySetting("room"+ i, DBHelper.STATE_OFF);
                Log.d("tagDB", "Boolean Insert DB Lights " + Setting);
            }
        }

        if(db.numberOfRowsAppliance() == 0){
            for(int i = 1; i < 15; i++){
                Setting = db.insertApplianceSetting("appliance"+ i, DBHelper.STATE_OFF);
                Log.d("tagDB", "Boolean Insert DB appliance " + Setting);
            }
        }

        if(db.numberOfRowsTemp() == 0){
            Setting = db.insertTempSetting(DBHelper.SUN,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.MON,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.TUE,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.WED,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.THR,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.FRI,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
            Setting = db.insertTempSetting(DBHelper.SAT,"70.0","70.0");
            Log.d("tagDB", "Boolean Insert DB temp " + Setting);
        }

        if(db.numberOfRowsAccess() == 0){
            for(int i = 1; i < 4; i++){
                Setting = db.insertAccessSetting("Area"+ i, DBHelper.STATE_ON);
                Log.d("tagDB", "Boolean DB Access " + Setting);
            }
        }

        if(db.numberOfRowsAdmHealth() == 0){
            Setting = db.insertAdmHealthSetting(DBHelper.SUN,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.MON,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.TUE,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.WED,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.THR,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.FRI,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
            Setting = db.insertAdmHealthSetting(DBHelper.SAT,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm health " + Setting);
        }

        if(db.numberOfRowsAdmEnergy() == 0){
            Setting = db.insertAdmEnergySetting(DBHelper.SUN,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.MON,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.TUE,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.WED,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.THR,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.FRI,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
            Setting = db.insertAdmEnergySetting(DBHelper.SAT,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm energy " + Setting);
        }

        if(db.numberOfRowsAdmProtect() == 0){
            Setting = db.insertAdmProtectSetting(DBHelper.SUN,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.MON,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.TUE,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.WED,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.THR,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.FRI,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
            Setting = db.insertAdmProtectSetting(DBHelper.SAT,"12:00AM","11:59PM");
            Log.d("tagDB", "Boolean Insert DB adm protect " + Setting);
        }

        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        SharedPreferences preferences = getSharedPreferences("authentic", MODE_PRIVATE);
        if(preferences.getBoolean("authentic", false)){

            transaction.replace(R.id.mainFrame, new AlertsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
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
                intent.putExtra(TITLE, ADMIN);
                startActivity(intent);
                return true;
            case R.id.health_menu:
                intent = new Intent(this, HealthActivity.class);
                intent.putExtra(TITLE, HEALTH);
                startActivity(intent);
                return true;
            case R.id.energy_menu:
                intent = new Intent(this, EnergyActivity.class);
                intent.putExtra(TITLE, ENERGY);
                startActivity(intent);
                return true;
            case R.id.protection_menu:
                intent = new Intent(this, ProtectionActivity.class);
                intent.putExtra(TITLE, PROTECTION);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onListFragmentInteraction(AlertsContent.DummyItem item) {

    }
}
