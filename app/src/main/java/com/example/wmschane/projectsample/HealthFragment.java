package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Rodrigo on 4/18/2017.
 */

public class HealthFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);

        Button alerts = (Button)view.findViewById(R.id.button4);
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new HealthAlertsFragment());
                transaction.commit();
        }});

        return view;
    }
}