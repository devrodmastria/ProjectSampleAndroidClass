package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Rodrigo on 4/10/2017.
 */

public class DayListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_days, container, false);



        ListView days = (ListView)view.findViewById(R.id.daysList);
        //TODO database and listview



        Button add = (Button)view.findViewById(R.id.adDayButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDateFragment newFrag = new SelectDateFragment();
                Bundle args = new Bundle();
                args.putString("from", "admin");
                newFrag.setArguments(args);

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, newFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return view;
    }
}