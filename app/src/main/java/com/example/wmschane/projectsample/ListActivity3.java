package com.example.wmschane.projectsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity3 extends Activity {

    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        listView2 = (ListView) findViewById(R.id.listView2);
        int resource = R.layout.activity_list2_item;
        String[] from = {"room", "checkbox", "ontext"};
        int[] to = {R.id.roomText, R.id.checkBox, R.id.onText};

        XMLinput_output fileIO = new XMLinput_output(getApplicationContext());
        ArrayList<HashMap<String, Object>> data = fileIO.readFile();

        SimpleAdapter adapter = new SimpleAdapter(this, data, resource, from, to);
        listView2.setAdapter(adapter);

    }

}
