package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProtectionDatabase(getApplicationContext());
        td= new TempDatabase(getApplicationContext());
        ad = new AppliancesDatabase(getApplicationContext());
        ed = new EnergyDatabase(getApplicationContext());
        md = new MainDataBase(getApplicationContext());


        boolean DaySet = td.insertSetting("Sunday","70","70");
        DaySet = td.insertSetting("Monday","70","70");
        DaySet = td.insertSetting("Tuesday","70","70");
        DaySet = td.insertSetting("Wednesday","70","70");
        DaySet = td.insertSetting("Thursday","70","70");
        DaySet = td.insertSetting("Friday","70","70");
        DaySet = td.insertSetting("Saturday","70","70");

        boolean LightSet;
        for(int i = 1; i < 15; i++){
            LightSet = ed.insertSetting("Room "+ i,"off");
        }

        boolean ProtectionSet;
        for(int i = 1; i < 15; i++){
            ProtectionSet = pd.insertSetting("Area "+ i,"off");
        }

        boolean ApplSet;
        for(int i = 1; i < 15; i++){
            ApplSet = ad.insertSetting("Appliance "+ i,"off");
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
