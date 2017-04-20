package com.example.wmschane.projectsample;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rodrigo on 4/18/2017.
 */

public class AdminSchedulesFragment extends Fragment {

    private Button sunOn, sunOff, monOn, monOff, tueOn, tueOff, wedOn, wedOff, thuOn, thuOff, friOn, friOff, satOn, satOff;
    private DBHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_energy, container, false);

        db = new DBHelper(getActivity());

        sunOn = (Button) view.findViewById(R.id.sunOn);
        sunOff = (Button)view.findViewById(R.id.sunOff);
        monOn = (Button)view.findViewById(R.id.monOn);
        monOff = (Button)view.findViewById(R.id.monOff);
        tueOn = (Button)view.findViewById(R.id.tueOn);
        tueOff = (Button)view.findViewById(R.id.tueOff);
        wedOn = (Button)view.findViewById(R.id.wedOn);
        wedOff = (Button)view.findViewById(R.id.wedOff);
        thuOn = (Button)view.findViewById(R.id.thuOn);
        thuOff = (Button)view.findViewById(R.id.thuOff);
        friOn = (Button)view.findViewById(R.id.friOn);
        friOff = (Button)view.findViewById(R.id.friOff);
        satOn = (Button)view.findViewById(R.id.satOn);
        satOff = (Button)view.findViewById(R.id.satOff);

        TextView title = (TextView)view.findViewById(R.id.textViewTitle);
        Bundle bundle = getArguments();
        final String admType = bundle.get(DBHelper.TABLE).toString();
        title.setText(admType + " arm times");

        if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){

            sunOn.setText(db.getAdmEnergySettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            sunOff.setText(db.getAdmEnergySettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            monOn.setText(db.getAdmEnergySettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            monOff.setText(db.getAdmEnergySettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            tueOn.setText(db.getAdmEnergySettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            tueOff.setText(db.getAdmEnergySettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            wedOn.setText(db.getAdmEnergySettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            wedOff.setText(db.getAdmEnergySettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            thuOn.setText(db.getAdmEnergySettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            thuOff.setText(db.getAdmEnergySettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            friOn.setText(db.getAdmEnergySettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            friOff.setText(db.getAdmEnergySettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            satOn.setText(db.getAdmEnergySettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            satOff.setText(db.getAdmEnergySettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){

            sunOn.setText(db.getAdmHealthSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            sunOff.setText(db.getAdmHealthSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            monOn.setText(db.getAdmHealthSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            monOff.setText(db.getAdmHealthSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            tueOn.setText(db.getAdmHealthSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            tueOff.setText(db.getAdmHealthSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            wedOn.setText(db.getAdmHealthSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            wedOff.setText(db.getAdmHealthSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            thuOn.setText(db.getAdmHealthSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            thuOff.setText(db.getAdmHealthSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            friOn.setText(db.getAdmHealthSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            friOff.setText(db.getAdmHealthSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            satOn.setText(db.getAdmHealthSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            satOff.setText(db.getAdmHealthSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        }else{

            sunOn.setText(db.getAdmProtectSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            sunOff.setText(db.getAdmProtectSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            monOn.setText(db.getAdmProtectSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            monOff.setText(db.getAdmProtectSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            tueOn.setText(db.getAdmProtectSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            tueOff.setText(db.getAdmProtectSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            wedOn.setText(db.getAdmProtectSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            wedOff.setText(db.getAdmProtectSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            thuOn.setText(db.getAdmProtectSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            thuOff.setText(db.getAdmProtectSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            friOn.setText(db.getAdmProtectSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            friOff.setText(db.getAdmProtectSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());
            satOn.setText(db.getAdmProtectSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_ON_TIME).toString());
            satOff.setText(db.getAdmProtectSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_OFF_TIME).toString());

        }

        //////////////////////////////////////////////////////////// Sunday



        sunOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.SUN);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, sunOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

        sunOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.SUN);
                args.putString(DBHelper.STATE_ON, sunOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });
//                .setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), sunOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.SUN, sunOn.getText().toString(), sunOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// monday



        monOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.MON);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, monOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), monOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.MON, monOn.getText().toString(), monOff.getText().toString());
//                }
//                return false;
//            }
//        });

        monOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.MON);
                args.putString(DBHelper.STATE_ON, monOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), monOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.MON, monOn.getText().toString(), monOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// tuesday




        tueOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.TUE);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, monOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), tueOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.TUE, tueOn.getText().toString(), tueOff.getText().toString());
//                }
//                return false;
//            }
//        });

        tueOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.TUE);
                args.putString(DBHelper.STATE_ON, tueOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), tueOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.TUE, tueOn.getText().toString(), tueOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// wednesday




        wedOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.WED);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, wedOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), wedOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.WED, wedOn.getText().toString(), wedOff.getText().toString());
//                }
//                return false;
//            }
//        });

        wedOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.WED);
                args.putString(DBHelper.STATE_ON, wedOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), wedOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.WED, wedOn.getText().toString(), wedOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// thursday




        thuOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.THR);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, thuOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), thuOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.THR, thuOn.getText().toString(), thuOff.getText().toString());
//                }
//                return false;
//            }
//        });

        thuOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.THR);
                args.putString(DBHelper.STATE_ON, thuOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), thuOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.THR, thuOn.getText().toString(), thuOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// Friday




        friOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.FRI);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, friOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), friOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.FRI, friOn.getText().toString(), friOff.getText().toString());
//                }
//                return false;
//            }
//        });

        friOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.FRI);
                args.putString(DBHelper.STATE_ON, friOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), friOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.FRI, friOn.getText().toString(), friOff.getText().toString());
//                }
//                return false;
//            }
//        });

        //////////////////////////////////////////////////////////// saturday




        satOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.SAT);
                args.putString(DBHelper.STATE_ON, DBHelper.FROM_TIME_PICKER);
                args.putString(DBHelper.STATE_OFF, satOff.getText().toString());
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), satOn.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.SAT, satOn.getText().toString(), satOff.getText().toString());
//                }
//                return false;
//            }
//        });

        satOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                Bundle args = new Bundle();
                if(admType.equals(DBHelper.TABLE_ADMIN_ENERGY)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_ENERGY);
                }else if(admType.equals(DBHelper.TABLE_ADMIN_HEALTH)){
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_HEALTH);
                }else{
                    args.putString(DBHelper.TABLE, DBHelper.TABLE_ADMIN_PROTECTION);
                }
                args.putString(DBHelper.DOW, DBHelper.SAT);
                args.putString(DBHelper.STATE_ON, satOn.getText().toString());
                args.putString(DBHelper.STATE_OFF, DBHelper.FROM_TIME_PICKER);
                newFragment.setArguments(args);
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

//                setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if(actionId == EditorInfo.IME_ACTION_DONE){
//                    Toast.makeText(getActivity(), satOff.getText(), Toast.LENGTH_SHORT).show();
//                    db.updateAdmEnergySetting(DBHelper.SAT, satOn.getText().toString(), satOff.getText().toString());
//                }
//                return false;
//            }
//        });

        return view;
    }
}
