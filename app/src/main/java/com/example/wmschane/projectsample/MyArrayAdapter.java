package com.example.wmschane.projectsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;


import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<ListObject>
{
    Context c;
    private ArrayList<ListObject> settingsList;

    MyArrayAdapter(Context c, int resource, ArrayList<ListObject> data)
    {
        super(c, resource, data);
        settingsList = new ArrayList<ListObject>();
        settingsList.addAll(data);
        this.c = c;
    }

    private class ListRowItems {
        TextView room;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListRowItems listRow = null;

        if (convertView == null) {
            // Must inflate all views in current row before they can be accessed properly
            LayoutInflater vi = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.fragment_room_item, null);

            listRow = new ListRowItems();

            listRow.room = (TextView) convertView.findViewById(R.id.roomText);
            convertView.setTag(listRow);
        }
        else {
            listRow = (ListRowItems) convertView.getTag();
        }

        // Save and display current row in the list
        ListObject obj = settingsList.get(position);
        listRow.room.setText(obj.getRoom());

        return convertView;
    }
}

