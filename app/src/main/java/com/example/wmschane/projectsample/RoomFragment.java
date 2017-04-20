package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class RoomFragment extends Fragment {

    ListView listView2;
    private String[] rooms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_list, container, false);

        listView2 = (ListView) view.findViewById(R.id.listView2);
        int resource = R.layout.fragment_room_item;

        // List example uses and ArrayAdapter instead of a SimpleAdapter.
        // The ArrayAdapter requires that the data be set up in an ArrayList.
        // The ArrayList should contain one object for each row of the list.
        // The object for each row must contain an item for each column.
        ArrayList<ListObject> data = new ArrayList<>();
        rooms = new String[]{"Garage", "Basement", "Master Suite", "Johny's Bedroom","Lilly's Bedroom", "Kitchen", "Bathroom", "Living room"};

        ListObject obj;
        for (Integer i = 0; i < rooms.length; i++) {
            obj = new ListObject(rooms[i], true, "ON");
            data.add(obj);
        }

        MyArrayAdapter adapter = new MyArrayAdapter(getActivity(), resource, data);
        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle extra = new Bundle();
                extra.putString(MainActivity.TITLE, rooms[position]);

                RoomViewFragment rvFrag = new RoomViewFragment();

                rvFrag.setArguments(extra);

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, rvFrag);
                transaction.commit();

            }
        });

        return view;

    }

}
