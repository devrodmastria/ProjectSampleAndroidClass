package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Rodrigo on 4/18/2017.
 */

public class RoomViewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_view, container, false);
        TextView titleView = (TextView)view.findViewById(R.id.roomName);

        Bundle fromBundle = getArguments();
        String title = fromBundle.getString(MainActivity.TITLE);
        if(title != null){
            titleView.setText(title);
        }

        return view;
    }
}