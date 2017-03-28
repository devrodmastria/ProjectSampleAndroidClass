package com.example.wmschane.projectsample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity5 extends Activity {

    ListView listView2;
    JSONList jlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        jlist = new JSONList(getApplicationContext());
        ArrayList<ListObject> list = new ArrayList<>(jlist.getListObjects());

        // Initial data for the settings table
        HashMap<String, Object> map;
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();

        for (Integer i=0; i<list.size(); i++)
        {
            map = new HashMap<>();
            map.put("room", list.get(i).getRoom());
            map.put("checkbox", list.get(i).getCheckbox());
            map.put("ontext", list.get(i).getOnText());
            data.add(map);
        }

        listView2 = (ListView) findViewById(R.id.listView2);
        int resource = R.layout.activity_list2_item;
        String[] from = {"room", "checkbox", "ontext"};
        int[] to = {R.id.roomText, R.id.checkBox, R.id.onText};

        SimpleAdapter adapter = new SimpleAdapter(this, data, resource, from, to);
        listView2.setAdapter(adapter);

   }

}
