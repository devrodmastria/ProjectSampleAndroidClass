package com.example.wmschane.projectsample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rodrigo on 4/18/2017.
 */

public class AdminProtectFragment extends Fragment {

    private EditText sunOn, sunOff, monOn, monOff, tueOn, tueOff, wedOn, wedOff, thuOn, thuOff, friOn, friOff, satOn, satOff;
    private DBHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_protect, container, false);

        db = new DBHelper(getActivity());

        //////////////////////////////////////////////////////////// Sunday
        sunOn = (EditText)view.findViewById(R.id.SunOn);
        sunOff = (EditText)view.findViewById(R.id.SunOff);

        sunOn.setText(db.getAdmProtectSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        sunOff.setText(db.getAdmProtectSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        sunOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), sunOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.SUN, sunOn.getText().toString(), sunOff.getText().toString());
                }
                return false;
            }
        });

        sunOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), sunOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.SUN, sunOn.getText().toString(), sunOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Monday
        monOn = (EditText)view.findViewById(R.id.MonOn);
        monOff = (EditText)view.findViewById(R.id.MonOff);

        monOn.setText(db.getAdmProtectSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        monOff.setText(db.getAdmProtectSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        monOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), monOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.MON, monOn.getText().toString(), monOff.getText().toString());
                }
                return false;
            }
        });

        monOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), monOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.MON, monOn.getText().toString(), monOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Tuesday
        tueOn = (EditText)view.findViewById(R.id.TueOn);
        tueOff = (EditText)view.findViewById(R.id.TueOff);

        tueOn.setText(db.getAdmProtectSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        tueOff.setText(db.getAdmProtectSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        tueOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), tueOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.TUE, tueOn.getText().toString(), tueOff.getText().toString());
                }
                return false;
            }
        });

        tueOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), tueOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.TUE, tueOn.getText().toString(), tueOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Wednesday
        wedOn = (EditText)view.findViewById(R.id.WedOn);
        wedOff = (EditText)view.findViewById(R.id.WedOff);

        wedOn.setText(db.getAdmProtectSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        wedOff.setText(db.getAdmProtectSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        wedOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), wedOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.WED, wedOn.getText().toString(), wedOff.getText().toString());
                }
                return false;
            }
        });

        wedOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), wedOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.WED, wedOn.getText().toString(), wedOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Thursday
        thuOn = (EditText)view.findViewById(R.id.ThuOn);
        thuOff = (EditText)view.findViewById(R.id.ThuOff);

        thuOn.setText(db.getAdmProtectSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        thuOff.setText(db.getAdmProtectSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        thuOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), thuOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.THR, thuOn.getText().toString(), thuOff.getText().toString());
                }
                return false;
            }
        });

        thuOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), thuOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.THR, thuOn.getText().toString(), thuOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Friday
        friOn = (EditText)view.findViewById(R.id.FriOn);
        friOff = (EditText)view.findViewById(R.id.FriOff);

        friOn.setText(db.getAdmProtectSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        friOff.setText(db.getAdmProtectSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        friOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), friOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.FRI, friOn.getText().toString(), friOff.getText().toString());
                }
                return false;
            }
        });

        friOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), friOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.FRI, friOn.getText().toString(), friOff.getText().toString());
                }
                return false;
            }
        });

        //////////////////////////////////////////////////////////// Saturday
        satOn = (EditText)view.findViewById(R.id.SatOn);
        satOff = (EditText)view.findViewById(R.id.SatOff);

        satOn.setText(db.getAdmProtectSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
        satOff.setText(db.getAdmProtectSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        satOn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), satOn.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.SAT, satOn.getText().toString(), satOff.getText().toString());
                }
                return false;
            }
        });

        satOff.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(getActivity(), satOff.getText(), Toast.LENGTH_SHORT).show();
                    db.updateAdmProtectSetting(DBHelper.SAT, satOn.getText().toString(), satOff.getText().toString());
                }
                return false;
            }
        });

        return view;
    }

}
