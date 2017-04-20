package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by Rodrigo on 4/9/2017.
 */

public class SelectTimeFragment extends Fragment {

    private DBHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_time, container, false);


//        Bundle fromBundle = getArguments();
//        String from = fromBundle.getString("from");
//
//        SelectTimeFragment newFrag = new SelectTimeFragment();
//        Bundle args = new Bundle();
//        args.putString("from", from);
//        args.putInt("date", datePicker.getDayOfMonth());
//        newFrag.setArguments(args);
//
//        FragmentTransaction transaction;
//        transaction = getFragmentManager().beginTransaction();
//        transaction.replace(android.R.id.content, newFrag);
//        transaction.addToBackStack(null);
//        transaction.commit();


        db = new DBHelper(getActivity());
        final TimePicker timePicker = (TimePicker)view.findViewById(R.id.timePicker);

        Button save = (Button)view.findViewById(R.id.saveTimeButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle fromBundle = getArguments();
                String from = fromBundle.getString(MainActivity.TITLE);

                //TODO save data to SQLite database


                int time = timePicker.getBaseline();


                switch (from){
                    case MainActivity.HEALTH:



                        break;
                    case MainActivity.ENERGY:


                        break;
                    case MainActivity.PROTECTION:


                        break;
                }

            }
        });

        return view;
    }

}
