package com.example.wmschane.projectsample;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Rodrigo on 4/20/2017.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    private DBHelper db;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        //Do something with the user chosen time

        db = new DBHelper(getActivity());

        Bundle fromBundle = getArguments();

        String TABLE = fromBundle.getString(DBHelper.TABLE);
        String DOW = fromBundle.getString(DBHelper.DOW);

        String STATE_ON = fromBundle.getString(DBHelper.STATE_ON);
        String STATE_OFF = fromBundle.getString(DBHelper.STATE_OFF);

        String FROM_TIME_PICKER = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);

        Button sunOn, sunOff, monOn, monOff, tueOn, tueOff, wedOn, wedOff, thuOn, thuOff, friOn, friOff, satOn, satOff;
        sunOn = (Button)getActivity().findViewById(R.id.sunOn);
        sunOff = (Button)getActivity().findViewById(R.id.sunOff);
        monOn = (Button)getActivity().findViewById(R.id.monOn);
        monOff = (Button)getActivity().findViewById(R.id.monOff);
        tueOn = (Button)getActivity().findViewById(R.id.tueOn);
        tueOff = (Button)getActivity().findViewById(R.id.tueOff);
        wedOn = (Button)getActivity().findViewById(R.id.wedOn);
        wedOff = (Button)getActivity().findViewById(R.id.wedOff);
        thuOn = (Button)getActivity().findViewById(R.id.thuOn);
        thuOff = (Button)getActivity().findViewById(R.id.thuOff);
        friOn = (Button)getActivity().findViewById(R.id.friOn);
        friOff = (Button)getActivity().findViewById(R.id.friOff);
        satOn = (Button)getActivity().findViewById(R.id.satOn);
        satOff = (Button)getActivity().findViewById(R.id.satOff);

        switch (TABLE){
            case DBHelper.TABLE_ADMIN_ENERGY:
                if(STATE_ON.equals(DBHelper.FROM_TIME_PICKER)){
                    db.updateAdmEnergySetting(DOW, FROM_TIME_PICKER, STATE_OFF);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOn.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    db.updateAdmEnergySetting(DOW, STATE_ON, FROM_TIME_PICKER);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOff.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case DBHelper.TABLE_ADMIN_HEALTH:
                if(STATE_ON.equals(DBHelper.FROM_TIME_PICKER)){
                    db.updateAdmHealthSetting(DOW, FROM_TIME_PICKER, STATE_OFF);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOn.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    db.updateAdmHealthSetting(DOW, STATE_ON, FROM_TIME_PICKER);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOff.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case DBHelper.TABLE_ADMIN_PROTECTION:
                if(STATE_ON.equals(DBHelper.FROM_TIME_PICKER)){
                    db.updateAdmProtectSetting(DOW, FROM_TIME_PICKER, STATE_OFF);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOn.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOn.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    db.updateAdmProtectSetting(DOW, STATE_ON, FROM_TIME_PICKER);
                    switch (DOW){
                        case DBHelper.SUN:
                            sunOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.MON:
                            monOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.TUE:
                            tueOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.WED:
                            wedOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.THR:
                            thuOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.FRI:
                            friOff.setText(FROM_TIME_PICKER);
                            break;
                        case DBHelper.SAT:
                            satOff.setText(FROM_TIME_PICKER);
                            break;
                        default:
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                Toast.makeText(getActivity(), "Error saving time", Toast.LENGTH_SHORT).show();
        }

    }
}
