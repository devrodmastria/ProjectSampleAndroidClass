package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * Created by Rodrigo on 4/9/2017.
 */

public class SelectDateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_date, container, false);

        final DatePicker datePicker = (DatePicker)view.findViewById(R.id.datePicker);

        Button next = (Button)view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle fromBundle = getArguments();
                String from = fromBundle.getString("from");

                SelectTimeFragment newFrag = new SelectTimeFragment();
                Bundle args = new Bundle();
                args.putString("from", from);
                args.putInt("date", datePicker.getDayOfMonth());
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
