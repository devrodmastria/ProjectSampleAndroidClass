package com.example.wmschane.projectsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
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
        CheckBox check;
        TextView onText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListRowItems listRow = null;

        if (convertView == null) {
            // Must inflate all views in current row before they can be accessed properly
            LayoutInflater vi = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.activity_list2_item, null);

            listRow = new ListRowItems();
            listRow.room = (TextView) convertView.findViewById(R.id.roomText);
            listRow.check = (CheckBox) convertView.findViewById(R.id.checkBox);
            listRow.onText = (TextView) convertView.findViewById(R.id.onText);
            convertView.setTag(listRow);
            // Must create a "final" version of listRow for use inside onClick.
            // Non-final version of listRow is not allowed there.
            final ListRowItems finalListRow = listRow;

            // Create a click listener only for the checkbox of the current row in the list
            listRow.check.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Only clickable item in each row of this list is a checkbox.
                    // If there is more than one clickable item, call getPosition(obj).
                    CheckBox checkBox = (CheckBox) v;
                    ListObject obj = (ListObject) checkBox.getTag();

                    // Switch value of checkbox and onText
                    if (obj.getCheckbox()) {
                        obj.setCheckbox(false);
                        obj.setOnText("OFF");
                        finalListRow.onText.setText("OFF");
                    }
                    else{
                        obj.setCheckbox(true);
                        obj.setOnText("ON");
                        finalListRow.onText.setText("ON");
                    }
                    checkBox.setTag(obj);
                }
            });
        }
        else {
            listRow = (ListRowItems) convertView.getTag();
        }

        // Save and display current row in the list
        ListObject obj = settingsList.get(position);
        listRow.room.setText(obj.getRoom());
        listRow.check.setChecked(obj.getCheckbox());
        listRow.onText.setText(obj.getOnText());
        listRow.check.setTag(obj);

        return convertView;
    }
}

