package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Rodrigo on 4/9/2017.
 */

public class SelectTimeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_time, container, false);

        final EditText startTime = (EditText)view.findViewById(R.id.startTime);

        final EditText endTime = (EditText)view.findViewById(R.id.endTime);

        Button save = (Button)view.findViewById(R.id.saveTimeButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String start = startTime.getText().toString();
                String stop = endTime.getText().toString();

                Bundle fromBundle = getArguments();
                String date = fromBundle.getString("date");
                String from = fromBundle.getString("from");

                //TODO save data to SQLite database

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                switch (from){
                    case "admin":
                        transaction.replace(android.R.id.content, new AdminFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case "energy":
                        transaction.replace(android.R.id.content, new EnergyFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                }

            }
        });

        return view;
    }

}
