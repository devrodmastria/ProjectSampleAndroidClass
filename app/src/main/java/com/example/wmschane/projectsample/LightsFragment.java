package com.example.wmschane.projectsample;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class LightsFragment extends Fragment implements View.OnClickListener {

    private DBHelper db;

    private CheckBox room1, room2, room3, room4, room5, room6, room7, room8, room9, room10,room11,room12, room13, room14;

    private TextView state1, state2, state3, state4, state5, state6, state7, state8, state9, state10, state11, state12, state13, state14;

    public LightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lights, container, false);

        db = new DBHelper(getActivity());

        Log.d("lightsDB", "DB room rows: " + db.numberOfRowsEnergy());

        room1 = (CheckBox)view.findViewById(R.id.checkBox1);
        state1 = (TextView)view.findViewById(R.id.viewOnText1);
        if (db.getEnergySettings("room1").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room1.setChecked(true);
            state1.setText("ON");
        }else {
            room1.setChecked(false);
            state1.setText("OFF");

        }
        room1.setOnClickListener(this);

        room2 = (CheckBox)view.findViewById(R.id.checkBox2);
        state2 = (TextView)view.findViewById(R.id.viewOnText2);
        if (db.getEnergySettings("room2").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room2.setChecked(true);
            state2.setText("ON");
        }else {
            room2.setChecked(false);
            state2.setText("OFF");
        }
        room2.setOnClickListener(this);

        room3 = (CheckBox)view.findViewById(R.id.checkBox3);
        state3 = (TextView)view.findViewById(R.id.viewOnText3);
        if (db.getEnergySettings("room3").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room3.setChecked(true);
            state3.setText("ON");
        }else {
            room3.setChecked(false);
            state3.setText("OFF");
        }
        room3.setOnClickListener(this);

        room4 = (CheckBox)view.findViewById(R.id.checkBox4);
        state4 = (TextView)view.findViewById(R.id.viewOnText4);
        if (db.getEnergySettings("room4").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room4.setChecked(true);
            state4.setText("ON");
        }else {
            room4.setChecked(false);
            state4.setText("OFF");
        }
        room4.setOnClickListener(this);

        room5 = (CheckBox)view.findViewById(R.id.checkBox5);
        state5 = (TextView)view.findViewById(R.id.viewOnText5);
        if (db.getEnergySettings("room5").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room5.setChecked(true);
            state5.setText("ON");
        }else {
            room5.setChecked(false);
            state5.setText("OFF");
        }
        room5.setOnClickListener(this);

        room6 = (CheckBox)view.findViewById(R.id.checkBox6);
        state6 = (TextView)view.findViewById(R.id.viewOnText6);
        if (db.getEnergySettings("room6").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room6.setChecked(true);
            state6.setText("ON");
        }else {
            room6.setChecked(false);
            state6.setText("OFF");
        }
        room6.setOnClickListener(this);

        room7 = (CheckBox)view.findViewById(R.id.checkBox7);
        state7 = (TextView)view.findViewById(R.id.viewOnText7);
        if (db.getEnergySettings("room7").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room7.setChecked(true);
            state7.setText("ON");
        }else {
            room7.setChecked(false);
            state7.setText("OFF");
        }
        room7.setOnClickListener(this);

        room8 = (CheckBox)view.findViewById(R.id.checkBox8);
        state8 = (TextView)view.findViewById(R.id.viewOnText8);
        if (db.getEnergySettings("room8").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room8.setChecked(true);
            state8.setText("ON");
        }else {
            room8.setChecked(false);
            state8.setText("OFF");
        }
        room8.setOnClickListener(this);

        room9 = (CheckBox)view.findViewById(R.id.checkBox9);
        state9 = (TextView)view.findViewById(R.id.viewOnText9);
        if (db.getEnergySettings("room9").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room9.setChecked(true);
            state9.setText("ON");
        }else {
            room9.setChecked(false);
            state9.setText("OFF");
        }
        room9.setOnClickListener(this);

        room10 = (CheckBox)view.findViewById(R.id.checkBox10);
        state10 = (TextView)view.findViewById(R.id.viewOnText10);
        if (db.getEnergySettings("room10").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room10.setChecked(true);
            state10.setText("ON");
        }else {
            room10.setChecked(false);
            state10.setText("OFF");
        }
        room10.setOnClickListener(this);

        room11 = (CheckBox)view.findViewById(R.id.checkBox11);
        state11 = (TextView)view.findViewById(R.id.viewOnText11);
        if (db.getEnergySettings("room11").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room11.setChecked(true);
            state11.setText("ON");
        }else {
            room11.setChecked(false);
            state11.setText("OFF");
        }
        room11.setOnClickListener(this);

        room12 = (CheckBox)view.findViewById(R.id.checkBox12);
        state12 = (TextView)view.findViewById(R.id.viewOnText12);
        if (db.getEnergySettings("room12").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room12.setChecked(true);
            state12.setText("ON");
        }else {
            room12.setChecked(false);
            state12.setText("OFF");
        }
        room12.setOnClickListener(this);

        room13 = (CheckBox)view.findViewById(R.id.checkBox13);
        state13 = (TextView)view.findViewById(R.id.viewOnText13);
        if (db.getEnergySettings("room13").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room13.setChecked(true);
            state13.setText("ON");
        }else {
            room13.setChecked(false);
            state13.setText("OFF");
        }
        room13.setOnClickListener(this);

        room14 = (CheckBox)view.findViewById(R.id.checkBox14);
        state14 = (TextView)view.findViewById(R.id.viewOnText14);
        if (db.getEnergySettings("room14").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
            room14.setChecked(true);
            state14.setText("ON");
        }else {
            room14.setChecked(false);
            state14.setText("OFF");
        }
        room14.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.checkBox1:

                if (db.getEnergySettings("room1").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room1", DBHelper.STATE_OFF);
                    room1.setChecked(false);
                    state1.setText("OFF");
                    Log.d("logindb", "DB data: " + db.getEnergySettings("room1").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString());

                }else {
                    db.updateEnergySetting("room1", DBHelper.STATE_ON);
                    room1.setChecked(true);
                    state1.setText("ON");
                    Log.d("logindb", "DB data: " + db.getEnergySettings("room1").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString());

                }
                break;

            case R.id.checkBox2:

                if (db.getEnergySettings("room2").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room2", DBHelper.STATE_OFF);
                    room2.setChecked(false);
                    state2.setText("OFF");
                    Log.d("logindb", "DB data: " + db.getEnergySettings("room2").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString());

                }else {
                    db.updateEnergySetting("room2", DBHelper.STATE_ON);
                    room2.setChecked(true);
                    state2.setText("ON");
                    Log.d("logindb", "DB data: " + db.getEnergySettings("room2").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString());

                }
                break;

            case R.id.checkBox3:

                if (db.getEnergySettings("room3").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room3", DBHelper.STATE_OFF);
                    room3.setChecked(false);
                    state3.setText("OFF");

                }else {
                    db.updateEnergySetting("room3", DBHelper.STATE_ON);
                    room3.setChecked(true);
                    state3.setText("ON");

                }
                break;

            case R.id.checkBox4:

                if (db.getEnergySettings("room4").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room4", DBHelper.STATE_OFF);
                    room4.setChecked(false);
                    state4.setText("OFF");

                }else {
                    db.updateEnergySetting("room4", DBHelper.STATE_ON);
                    room4.setChecked(true);
                    state4.setText("ON");

                }
                break;

            case R.id.checkBox5:

                if (db.getEnergySettings("room5").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room5", DBHelper.STATE_OFF);
                    room5.setChecked(false);
                    state5.setText("OFF");

                }else {
                    db.updateEnergySetting("room5", DBHelper.STATE_ON);
                    room5.setChecked(true);
                    state5.setText("ON");

                }
                break;

            case R.id.checkBox6:

                if (db.getEnergySettings("room6").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room6", DBHelper.STATE_OFF);
                    room6.setChecked(false);
                    state6.setText("OFF");

                }else {
                    db.updateEnergySetting("room6", DBHelper.STATE_ON);
                    room6.setChecked(true);
                    state6.setText("ON");

                }
                break;

            case R.id.checkBox7:

                if (db.getEnergySettings("room7").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room7", DBHelper.STATE_OFF);
                    room7.setChecked(false);
                    state7.setText("OFF");

                }else {
                    db.updateEnergySetting("room7", DBHelper.STATE_ON);
                    room7.setChecked(true);
                    state7.setText("ON");

                }
                break;

            case R.id.checkBox8:

                if (db.getEnergySettings("room8").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room8", DBHelper.STATE_OFF);
                    room8.setChecked(false);
                    state8.setText("OFF");

                }else {
                    db.updateEnergySetting("room8", DBHelper.STATE_ON);
                    room8.setChecked(true);
                    state8.setText("ON");

                }
                break;

            case R.id.checkBox9:

                if (db.getEnergySettings("room9").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room9", DBHelper.STATE_OFF);
                    room9.setChecked(false);
                    state9.setText("OFF");

                }else {
                    db.updateEnergySetting("room9", DBHelper.STATE_ON);
                    room9.setChecked(true);
                    state9.setText("ON");

                }
                break;

            case R.id.checkBox10:

                if (db.getEnergySettings("room10").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room10", DBHelper.STATE_OFF);
                    room10.setChecked(false);
                    state10.setText("OFF");

                }else {
                    db.updateEnergySetting("room10", DBHelper.STATE_ON);
                    room10.setChecked(true);
                    state10.setText("ON");

                }
                break;

            case R.id.checkBox11:

                if (db.getEnergySettings("room11").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room11", DBHelper.STATE_OFF);
                    room11.setChecked(false);
                    state11.setText("OFF");

                }else {
                    db.updateEnergySetting("room11", DBHelper.STATE_ON);
                    room11.setChecked(true);
                    state11.setText("ON");

                }
                break;

            case R.id.checkBox12:

                if (db.getEnergySettings("room12").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room12", DBHelper.STATE_OFF);
                    room12.setChecked(false);
                    state12.setText("OFF");

                }else {
                    db.updateEnergySetting("room12", DBHelper.STATE_ON);
                    room12.setChecked(true);
                    state12.setText("ON");

                }
                break;

            case R.id.checkBox13:

                if (db.getEnergySettings("room13").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room13", DBHelper.STATE_OFF);
                    room13.setChecked(false);
                    state13.setText("OFF");

                }else {
                    db.updateEnergySetting("room13", DBHelper.STATE_ON);
                    room13.setChecked(true);
                    state13.setText("ON");

                }
                break;

            case R.id.checkBox14:

                if (db.getEnergySettings("room14").get(0).get(DBHelper.COLUMN_ROOM_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateEnergySetting("room14", DBHelper.STATE_OFF);
                    room14.setChecked(false);
                    state14.setText("OFF");

                }else {
                    db.updateEnergySetting("room14", DBHelper.STATE_ON);
                    room14.setChecked(true);
                    state14.setText("ON");

                }
                break;

        }
    }
}
