package com.example.wmschane.projectsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;


public class ListActivity2 extends Activity {

    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        listView2 = (ListView) findViewById(R.id.listView2);
        int resource = R.layout.activity_list2_item;

        // List example uses and ArrayAdapter instead of a SimpleAdapter.
        // The ArrayAdapter requires that the data be set up in an ArrayList.
        // The ArrayList should contain one object for each row of the list.
        // The object for each row must contain an item for each column.
        ArrayList<ListObject> data = new ArrayList<>();
        String[] rooms = {"Bedroom 1", "Kitchen", "Bathroom"};

        ListObject obj;
        for (Integer i = 0; i < 3; i++) {
            obj = new ListObject(rooms[i], true, "ON");
            data.add(obj);
        }

        MyArrayAdapter adapter = new MyArrayAdapter(this, resource, data);
        listView2.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
