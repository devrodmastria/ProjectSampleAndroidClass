package com.example.wmschane.projectsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity4 extends Activity {

    ListView listView2;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        db = new DBHelper(getApplicationContext());

        // Initial data for the settings table
        boolean res = db.insertSetting("Bedroom 2", true, "ON");
        res = db.insertSetting("Bathroom 1", true, "ON");
        res = db.updateSetting("Bathroom 1", false, "OFF");
        res = db.insertSetting("Front Porch", true, "ON");
        res = db.insertSetting("Basement", false, "OFF");
        res = db.insertSetting("Bathroom 2", true, "ON");
        int resDelete = db.deleteSetting("Bathroom 2");

        listView2 = (ListView) findViewById(R.id.listView2);
        int resource = R.layout.activity_list2_item;
        String[] from = {"room", "checkbox", "ontext"};
        int[] to = {R.id.roomText, R.id.checkBox, R.id.onText};

        // Pass primary key value to select rows from settings table.
        // If Primary key is null, all rows will be returned.
        ArrayList<HashMap<String, Object>> data = db.getSettings(null);

        SimpleAdapter adapter = new SimpleAdapter(this, data, resource, from, to);
        listView2.setAdapter(adapter);

   }

}
