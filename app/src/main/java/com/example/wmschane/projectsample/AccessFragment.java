package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Rodrigo on 4/10/2017.
 */

public class AccessFragment extends Fragment implements View.OnClickListener{

    private CheckBox frontBox, backBox, garageBox;
    private TextView front, back, garage;
    private DBHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_access, container, false);

        db = new DBHelper(getActivity());

        frontBox = (CheckBox)view.findViewById(R.id.checkBoxLockFront);
        front = (TextView)view.findViewById(R.id.viewOnText1);
        if (db.getAccessSettings("Area1").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)){
            frontBox.setChecked(true);
            front.setText("LOCKED");
        }else {
            frontBox.setChecked(false);
            front.setText("UNLOCKED");

        }
        frontBox.setOnClickListener(this);

        backBox = (CheckBox)view.findViewById(R.id.checkBoxLockBack);
        back = (TextView)view.findViewById(R.id.viewOnText2);
        if (db.getAccessSettings("Area2").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)){
            backBox.setChecked(true);
            back.setText("LOCKED");
        }else {
            backBox.setChecked(false);
            back.setText("UNLOCKED");

        }
        backBox.setOnClickListener(this);

        garageBox = (CheckBox)view.findViewById(R.id.checkBoxLockGarage);
        garage = (TextView)view.findViewById(R.id.viewOnText3);
        if (db.getAccessSettings("Area3").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)){
            garageBox.setChecked(true);
            garage.setText("LOCKED");
        }else {
            garageBox.setChecked(false);
            garage.setText("UNLOCKED");

        }
        garageBox.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkBoxLockFront:

                if (db.getAccessSettings("Area1").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)) {
                    db.updateAccessSetting("Area1", DBHelper.STATE_OFF);
                    frontBox.setChecked(false);
                    front.setText("UNLOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area1").get(0).get(DBHelper.COLUMN_STATUS).toString());

                } else {
                    db.updateAccessSetting("Area1", DBHelper.STATE_ON);
                    frontBox.setChecked(true);
                    front.setText("LOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area1").get(0).get(DBHelper.COLUMN_STATUS).toString());

                }
                break;

            case R.id.checkBoxLockBack:

                if (db.getAccessSettings("Area2").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)) {
                    db.updateAccessSetting("Area2", DBHelper.STATE_OFF);
                    backBox.setChecked(false);
                    back.setText("UNLOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area2").get(0).get(DBHelper.COLUMN_STATUS).toString());

                } else {
                    db.updateAccessSetting("Area2", DBHelper.STATE_ON);
                    backBox.setChecked(true);
                    back.setText("LOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area2").get(0).get(DBHelper.COLUMN_STATUS).toString());

                }
                break;

            case R.id.checkBoxLockGarage:

                if (db.getAccessSettings("Area3").get(0).get(DBHelper.COLUMN_STATUS).toString().equals(DBHelper.STATE_ON)) {
                    db.updateAccessSetting("Area3", DBHelper.STATE_OFF);
                    garageBox.setChecked(false);
                    garage.setText("UNLOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area3").get(0).get(DBHelper.COLUMN_STATUS).toString());

                } else {
                    db.updateAccessSetting("Area3", DBHelper.STATE_ON);
                    garageBox.setChecked(true);
                    garage.setText("LOCKED");
                    Log.d("logindb", "DB data: " + db.getAccessSettings("Area3").get(0).get(DBHelper.COLUMN_STATUS).toString());
                }
                break;
        }
    }
}
