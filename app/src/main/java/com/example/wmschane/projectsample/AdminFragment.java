package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Rodrigo on 4/9/2017.
 */

public class AdminFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        Button healthBtn = (Button)view.findViewById(R.id.healthButton);
        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSchedulesFragment newFrag = new AdminSchedulesFragment();
                Bundle args = new Bundle();
                args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                newFrag.setArguments(args);

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFrag);
                transaction.addToBackStack(null);
                transaction.commit();

//                AdminHealthFragment newFrag = new AdminHealthFragment();
//                Bundle args = new Bundle();
//                args.putString("from", "admin");
//                newFrag.setArguments(args);
//
//                FragmentTransaction transaction;
//                transaction = getFragmentManager().beginTransaction();
//                transaction.replace(android.R.id.content, newFrag);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });
        Button energyBtn = (Button)view.findViewById(R.id.energyButton);
        energyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSchedulesFragment newFrag = new AdminSchedulesFragment();
                Bundle args = new Bundle();
                args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                newFrag.setArguments(args);

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Button protectionBtn = (Button)view.findViewById(R.id.protectionButton);
        protectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSchedulesFragment newFrag = new AdminSchedulesFragment();
                Bundle args = new Bundle();
                args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                newFrag.setArguments(args);

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
//
//                AdminProtectFragment newFrag = new AdminProtectFragment();
//                Bundle args = new Bundle();
//                args.putString("from", "admin");
//                newFrag.setArguments(args);
//
//                FragmentTransaction transaction;
//                transaction = getFragmentManager().beginTransaction();
//                transaction.replace(android.R.id.content, newFrag);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

        return view;
    }

}
