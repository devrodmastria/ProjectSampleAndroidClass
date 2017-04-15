package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ProtectionFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_protection, container, false);


//        ArrayList<HashMap<String, Object>> data = db.getSettings(null);
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, resource, from, to);
//        listView2.setAdapter(adapter);


        Button viewRoom =(Button)view.findViewById(R.id.viewRoomButton);
        viewRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new RoomFragment());
                transaction.commit();

            }
        });

        Button alerts = (Button)view.findViewById(R.id.alertsHistoryButton);
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new AlertsFragment());
                transaction.commit();
            }
        });

        Button access = (Button)view.findViewById(R.id.accessButton);
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new AccessFragment());
                transaction.commit();
            }
        });

        return view;
    }

}
