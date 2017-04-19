package com.example.wmschane.projectsample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class ApplianceFragment extends Fragment implements View.OnClickListener{


    private DBHelper db;

    private CheckBox appliance1, appliance2, appliance3, appliance4, appliance5, appliance6, appliance7, appliance8, appliance9, appliance10,appliance11,appliance12, appliance13, appliance14;

    private TextView state1, state2, state3, state4, state5, state6, state7, state8, state9, state10, state11, state12, state13, state14;

    public ApplianceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appliance, container, false);

        db = new DBHelper(getActivity());

        Log.d("appliancesDB", "DB appliance rows: " + db.numberOfRowsEnergy());

        appliance1 = (CheckBox)view.findViewById(R.id.checkBox1);
        state1 = (TextView)view.findViewById(R.id.viewOnText1);
        if (db.getApplianceSettings("appliance1").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance1.setChecked(true);
            state1.setText("ON");
        }else {
            appliance1.setChecked(false);
            state1.setText("OFF");

        }
        appliance1.setOnClickListener(this);

        appliance2 = (CheckBox)view.findViewById(R.id.checkBox2);
        state2 = (TextView)view.findViewById(R.id.viewOnText2);
        if (db.getApplianceSettings("appliance2").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance2.setChecked(true);
            state2.setText("ON");
        }else {
            appliance2.setChecked(false);
            state2.setText("OFF");
        }
        appliance2.setOnClickListener(this);

        appliance3 = (CheckBox)view.findViewById(R.id.checkBox3);
        state3 = (TextView)view.findViewById(R.id.viewOnText3);
        if (db.getApplianceSettings("appliance3").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance3.setChecked(true);
            state3.setText("ON");
        }else {
            appliance3.setChecked(false);
            state3.setText("OFF");
        }
        appliance3.setOnClickListener(this);

        appliance4 = (CheckBox)view.findViewById(R.id.checkBox4);
        state4 = (TextView)view.findViewById(R.id.viewOnText4);
        if (db.getApplianceSettings("appliance4").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance4.setChecked(true);
            state4.setText("ON");
        }else {
            appliance4.setChecked(false);
            state4.setText("OFF");
        }
        appliance4.setOnClickListener(this);

        appliance5 = (CheckBox)view.findViewById(R.id.checkBox5);
        state5 = (TextView)view.findViewById(R.id.viewOnText5);
        if (db.getApplianceSettings("appliance5").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance5.setChecked(true);
            state5.setText("ON");
        }else {
            appliance5.setChecked(false);
            state5.setText("OFF");
        }
        appliance5.setOnClickListener(this);

        appliance6 = (CheckBox)view.findViewById(R.id.checkBox6);
        state6 = (TextView)view.findViewById(R.id.viewOnText6);
        if (db.getApplianceSettings("appliance6").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance6.setChecked(true);
            state6.setText("ON");
        }else {
            appliance6.setChecked(false);
            state6.setText("OFF");
        }
        appliance6.setOnClickListener(this);

        appliance7 = (CheckBox)view.findViewById(R.id.checkBox7);
        state7 = (TextView)view.findViewById(R.id.viewOnText7);
        if (db.getApplianceSettings("appliance7").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance7.setChecked(true);
            state7.setText("ON");
        }else {
            appliance7.setChecked(false);
            state7.setText("OFF");
        }
        appliance7.setOnClickListener(this);

        appliance8 = (CheckBox)view.findViewById(R.id.checkBox8);
        state8 = (TextView)view.findViewById(R.id.viewOnText8);
        if (db.getApplianceSettings("appliance8").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance8.setChecked(true);
            state8.setText("ON");
        }else {
            appliance8.setChecked(false);
            state8.setText("OFF");
        }
        appliance8.setOnClickListener(this);

        appliance9 = (CheckBox)view.findViewById(R.id.checkBox9);
        state9 = (TextView)view.findViewById(R.id.viewOnText9);
        if (db.getApplianceSettings("appliance9").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance9.setChecked(true);
            state9.setText("ON");
        }else {
            appliance9.setChecked(false);
            state9.setText("OFF");
        }
        appliance9.setOnClickListener(this);

        appliance10 = (CheckBox)view.findViewById(R.id.checkBox10);
        state10 = (TextView)view.findViewById(R.id.viewOnText10);
        if (db.getApplianceSettings("appliance10").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance10.setChecked(true);
            state10.setText("ON");
        }else {
            appliance10.setChecked(false);
            state10.setText("OFF");
        }
        appliance10.setOnClickListener(this);

        appliance11 = (CheckBox)view.findViewById(R.id.checkBox11);
        state11 = (TextView)view.findViewById(R.id.viewOnText11);
        if (db.getApplianceSettings("appliance11").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance11.setChecked(true);
            state11.setText("ON");
        }else {
            appliance11.setChecked(false);
            state11.setText("OFF");
        }
        appliance11.setOnClickListener(this);

        appliance12 = (CheckBox)view.findViewById(R.id.checkBox12);
        state12 = (TextView)view.findViewById(R.id.viewOnText12);
        if (db.getApplianceSettings("appliance12").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance12.setChecked(true);
            state12.setText("ON");
        }else {
            appliance12.setChecked(false);
            state12.setText("OFF");
        }
        appliance12.setOnClickListener(this);

        appliance13 = (CheckBox)view.findViewById(R.id.checkBox13);
        state13 = (TextView)view.findViewById(R.id.viewOnText13);
        if (db.getApplianceSettings("appliance13").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance13.setChecked(true);
            state13.setText("ON");
        }else {
            appliance13.setChecked(false);
            state13.setText("OFF");
        }
        appliance13.setOnClickListener(this);

        appliance14 = (CheckBox)view.findViewById(R.id.checkBox14);
        state14 = (TextView)view.findViewById(R.id.viewOnText14);
        if (db.getApplianceSettings("appliance14").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
            appliance14.setChecked(true);
            state14.setText("ON");
        }else {
            appliance14.setChecked(false);
            state14.setText("OFF");
        }
        appliance14.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.checkBox1:

                if (db.getApplianceSettings("appliance1").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance1", DBHelper.STATE_OFF);
                    appliance1.setChecked(false);
                    state1.setText("OFF");
                    Log.d("logindb", "DB data: " + db.getApplianceSettings("appliance1").get(0).get(DBHelper.COLUMN_APL_STATE).toString());

                }else {
                    db.updateApplianceSetting("appliance1", DBHelper.STATE_ON);
                    appliance1.setChecked(true);
                    state1.setText("ON");
                    Log.d("logindb", "DB data: " + db.getApplianceSettings("appliance1").get(0).get(DBHelper.COLUMN_APL_STATE).toString());

                }
                break;

            case R.id.checkBox2:

                if (db.getApplianceSettings("appliance2").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance2", DBHelper.STATE_OFF);
                    appliance2.setChecked(false);
                    state2.setText("OFF");
                    Log.d("logindb", "DB data: " + db.getApplianceSettings("appliance2").get(0).get(DBHelper.COLUMN_APL_STATE).toString());

                }else {
                    db.updateApplianceSetting("appliance2", DBHelper.STATE_ON);
                    appliance2.setChecked(true);
                    state2.setText("ON");
                    Log.d("logindb", "DB data: " + db.getApplianceSettings("appliance2").get(0).get(DBHelper.COLUMN_APL_STATE).toString());

                }
                break;

            case R.id.checkBox3:

                if (db.getApplianceSettings("appliance3").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance3", DBHelper.STATE_OFF);
                    appliance3.setChecked(false);
                    state3.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance3", DBHelper.STATE_ON);
                    appliance3.setChecked(true);
                    state3.setText("ON");

                }
                break;

            case R.id.checkBox4:

                if (db.getApplianceSettings("appliance4").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance4", DBHelper.STATE_OFF);
                    appliance4.setChecked(false);
                    state4.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance4", DBHelper.STATE_ON);
                    appliance4.setChecked(true);
                    state4.setText("ON");

                }
                break;

            case R.id.checkBox5:

                if (db.getApplianceSettings("appliance5").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance5", DBHelper.STATE_OFF);
                    appliance5.setChecked(false);
                    state5.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance5", DBHelper.STATE_ON);
                    appliance5.setChecked(true);
                    state5.setText("ON");

                }
                break;

            case R.id.checkBox6:

                if (db.getApplianceSettings("appliance6").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance6", DBHelper.STATE_OFF);
                    appliance6.setChecked(false);
                    state6.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance6", DBHelper.STATE_ON);
                    appliance6.setChecked(true);
                    state6.setText("ON");

                }
                break;

            case R.id.checkBox7:

                if (db.getApplianceSettings("appliance7").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance7", DBHelper.STATE_OFF);
                    appliance7.setChecked(false);
                    state7.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance7", DBHelper.STATE_ON);
                    appliance7.setChecked(true);
                    state7.setText("ON");

                }
                break;

            case R.id.checkBox8:

                if (db.getApplianceSettings("appliance8").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance8", DBHelper.STATE_OFF);
                    appliance8.setChecked(false);
                    state8.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance8", DBHelper.STATE_ON);
                    appliance8.setChecked(true);
                    state8.setText("ON");

                }
                break;

            case R.id.checkBox9:

                if (db.getApplianceSettings("appliance9").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance9", DBHelper.STATE_OFF);
                    appliance9.setChecked(false);
                    state9.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance9", DBHelper.STATE_ON);
                    appliance9.setChecked(true);
                    state9.setText("ON");

                }
                break;

            case R.id.checkBox10:

                if (db.getApplianceSettings("appliance10").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance10", DBHelper.STATE_OFF);
                    appliance10.setChecked(false);
                    state10.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance10", DBHelper.STATE_ON);
                    appliance10.setChecked(true);
                    state10.setText("ON");

                }
                break;

            case R.id.checkBox11:

                if (db.getApplianceSettings("appliance11").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance11", DBHelper.STATE_OFF);
                    appliance11.setChecked(false);
                    state11.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance11", DBHelper.STATE_ON);
                    appliance11.setChecked(true);
                    state11.setText("ON");

                }
                break;

            case R.id.checkBox12:

                if (db.getApplianceSettings("appliance12").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance12", DBHelper.STATE_OFF);
                    appliance12.setChecked(false);
                    state12.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance12", DBHelper.STATE_ON);
                    appliance12.setChecked(true);
                    state12.setText("ON");

                }
                break;

            case R.id.checkBox13:

                if (db.getApplianceSettings("appliance13").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance13", DBHelper.STATE_OFF);
                    appliance13.setChecked(false);
                    state13.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance13", DBHelper.STATE_ON);
                    appliance13.setChecked(true);
                    state13.setText("ON");

                }
                break;

            case R.id.checkBox14:

                if (db.getApplianceSettings("appliance14").get(0).get(DBHelper.COLUMN_APL_STATE).toString().equals(DBHelper.STATE_ON)){
                    db.updateApplianceSetting("appliance14", DBHelper.STATE_OFF);
                    appliance14.setChecked(false);
                    state14.setText("OFF");

                }else {
                    db.updateApplianceSetting("appliance14", DBHelper.STATE_ON);
                    appliance14.setChecked(true);
                    state14.setText("ON");

                }
                break;

        }


    }
}
