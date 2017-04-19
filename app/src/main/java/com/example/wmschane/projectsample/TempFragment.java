package com.example.wmschane.projectsample;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class TempFragment extends Fragment implements OnClickListener{

    private Button UpSun, DownSun, UpSunNight, DownSunNight;
    private Button UpMon, DownMon, UpMonNight, DownMonNight;
    private Button UpTue, DownTue, UpTueNight, DownTueNight;
    private Button UpWed, DownWed, UpWedNight, DownWedNight;
    private Button UpThr, DownThr, UpThrNight, DownThrNight;
    private Button UpFri, DownFri, UpFriNight, DownFriNight;
    private Button UpSat, DownSat, UpSatNight, DownSatNight;

    private EditText SunTemp, SunNightTemp;
    private EditText MonTemp, MonNightTemp;
    private EditText TueTemp, TueNightTemp;
    private EditText WedTemp, WedNightTemp;
    private EditText ThrTemp, ThrNightTemp;
    private EditText FriTemp, FriNightTemp;
    private EditText SatTemp, SatNightTemp;

    private DBHelper db;

    public TempFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        db = new DBHelper(getActivity());

        //Sunday row
        UpSun = (Button) view.findViewById(R.id.PlusSunDay);
        DownSun = (Button) view.findViewById(R.id.MinusSunDay);
        UpSunNight = (Button) view.findViewById(R.id.PlusSundayNight);
        DownSunNight = (Button) view.findViewById(R.id.MinusSundayNight);

        UpSun.setOnClickListener(this);
        DownSun.setOnClickListener(this);
        UpSunNight.setOnClickListener(this);
        DownSunNight.setOnClickListener(this);

        SunTemp = (EditText) view.findViewById(R.id.DegreeSunDay);
        SunTemp.setText(db.getTempSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_DAY).toString());

        SunNightTemp = (EditText) view.findViewById(R.id.DegreeSundayNight);
        SunNightTemp.setText(db.getTempSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Monday row
        UpMon = (Button) view.findViewById(R.id.PlusMondayDay);
        DownMon = (Button) view.findViewById(R.id.MinusMondayDay);
        UpMonNight = (Button) view.findViewById(R.id.PlusMondayNight);
        DownMonNight = (Button) view.findViewById(R.id.MinusMondayNight);

        UpMon.setOnClickListener(this);
        DownMon.setOnClickListener(this);
        UpMonNight.setOnClickListener(this);
        DownMonNight.setOnClickListener(this);

        MonTemp = (EditText) view.findViewById(R.id.DegreeMondayDay);
        MonTemp.setText(db.getTempSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_DAY).toString());

        MonNightTemp = (EditText) view.findViewById(R.id.DegreeMondayNight);
        MonNightTemp.setText(db.getTempSettings(DBHelper.MON).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Tuesday row
        UpTue = (Button) view.findViewById(R.id.PlusTuesdayDay);
        DownTue = (Button) view.findViewById(R.id.MinusTuesdayDay);
        UpTueNight = (Button) view.findViewById(R.id.PlusTuesdayNight);
        DownTueNight = (Button) view.findViewById(R.id.MinusTuesdayNight);

        UpTue.setOnClickListener(this);
        DownTue.setOnClickListener(this);
        UpTueNight.setOnClickListener(this);
        DownTueNight.setOnClickListener(this);

        TueTemp = (EditText) view.findViewById(R.id.DegreeTuesdayDay);
        TueTemp.setText(db.getTempSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_DAY).toString());

        TueNightTemp = (EditText) view.findViewById(R.id.DegreeTuesdayNight);
        TueNightTemp.setText(db.getTempSettings(DBHelper.TUE).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Wednesday row
        UpWed = (Button) view.findViewById(R.id.PlusWedDay);
        DownWed = (Button) view.findViewById(R.id.MinusWedDay);
        UpWedNight = (Button) view.findViewById(R.id.PlusWedNight);
        DownWedNight = (Button) view.findViewById(R.id.MinusWedNight);

        UpWed.setOnClickListener(this);
        DownWed.setOnClickListener(this);
        UpWedNight.setOnClickListener(this);
        DownWedNight.setOnClickListener(this);

        WedTemp = (EditText) view.findViewById(R.id.DegreeWedDay);
        WedTemp.setText(db.getTempSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_DAY).toString());

        WedNightTemp = (EditText) view.findViewById(R.id.DegreeWedNight);
        WedNightTemp.setText(db.getTempSettings(DBHelper.WED).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Thursday row
        UpThr = (Button) view.findViewById(R.id.PlusThuDay);
        DownThr = (Button) view.findViewById(R.id.MinusThuDay);
        UpThrNight = (Button) view.findViewById(R.id.PlusThuNight);
        DownThrNight = (Button) view.findViewById(R.id.MinusThuNight);

        UpThr.setOnClickListener(this);
        DownThr.setOnClickListener(this);
        UpThrNight.setOnClickListener(this);
        DownThrNight.setOnClickListener(this);

        ThrTemp = (EditText) view.findViewById(R.id.DegreeThuDay);
        ThrTemp.setText(db.getTempSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_DAY).toString());

        ThrNightTemp = (EditText) view.findViewById(R.id.DegreeThuNight);
        ThrNightTemp.setText(db.getTempSettings(DBHelper.THR).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Friday row
        UpFri = (Button) view.findViewById(R.id.PlusFriDay);
        DownFri = (Button) view.findViewById(R.id.MinusFriDay);
        UpFriNight = (Button) view.findViewById(R.id.PlusFriNight);
        DownFriNight = (Button) view.findViewById(R.id.MinusFriNight);

        UpFri.setOnClickListener(this);
        DownFri.setOnClickListener(this);
        UpFriNight.setOnClickListener(this);
        DownFriNight.setOnClickListener(this);

        FriTemp = (EditText) view.findViewById(R.id.DegreeFriDay);
        FriTemp.setText(db.getTempSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_DAY).toString());

        FriNightTemp = (EditText) view.findViewById(R.id.DegreeFriNight);
        FriNightTemp.setText(db.getTempSettings(DBHelper.FRI).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        //Saturday row
        UpSat = (Button) view.findViewById(R.id.PlusSatDay);
        DownSat = (Button) view.findViewById(R.id.MinusSatDay);
        UpSatNight = (Button) view.findViewById(R.id.PlusSatNight);
        DownSatNight = (Button) view.findViewById(R.id.MinusSatNight);

        UpSat.setOnClickListener(this);
        DownSat.setOnClickListener(this);
        UpSatNight.setOnClickListener(this);
        DownSatNight.setOnClickListener(this);

        SatTemp = (EditText) view.findViewById(R.id.DegreeSatDay);
        SatTemp.setText(db.getTempSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_DAY).toString());

        SatNightTemp = (EditText) view.findViewById(R.id.DegreeSatNight);
        SatNightTemp.setText(db.getTempSettings(DBHelper.SAT).get(0).get(DBHelper.COLUMN_NIGHT).toString());

        return view;

    }

    @Override
    public void onClick(View v){

        switch (v.getId()){

            /////////////////////// Sunday
            case R.id.MinusSunDay:
                double degreeValue = Double.parseDouble(SunTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                SunTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SUN, String.valueOf(degreeValue), SunNightTemp.getText().toString());
                Log.d("tempDB", "DB temp data " + db.getTempSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_DAY).toString());
                break;

            case R.id.PlusSunDay:
                degreeValue = Double.parseDouble(SunTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                SunTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SUN, String.valueOf(degreeValue), SunNightTemp.getText().toString());
                Log.d("tempDB", "DB temp data " + db.getTempSettings(DBHelper.SUN).get(0).get(DBHelper.COLUMN_DAY).toString());
                break;

            case R.id.MinusSundayNight:
                degreeValue = Double.parseDouble(SunNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                SunNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SUN, SunTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusSundayNight:
                degreeValue = Double.parseDouble(SunNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                SunNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SUN, SunTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            /////////////////////// Monday
            case R.id.MinusMondayDay:
                degreeValue = Double.parseDouble(MonTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                MonTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.MON, String.valueOf(degreeValue), MonNightTemp.getText().toString());
                break;

            case R.id.PlusMondayDay:
                degreeValue = Double.parseDouble(MonTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                MonTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.MON, String.valueOf(degreeValue), MonNightTemp.getText().toString());
                break;

            case R.id.MinusMondayNight:
                degreeValue = Double.parseDouble(MonNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                MonNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.MON, MonTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusMondayNight:
                degreeValue = Double.parseDouble(MonNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                MonNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.MON, MonTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            /////////////////////// Tuesday
            case R.id.MinusTuesdayDay:
                degreeValue = Double.parseDouble(TueTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                TueTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.TUE, String.valueOf(degreeValue), TueNightTemp.getText().toString());
                break;

            case R.id.PlusTuesdayDay:
                degreeValue = Double.parseDouble(TueTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                TueTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.TUE, String.valueOf(degreeValue), TueNightTemp.getText().toString());
                break;

            case R.id.MinusTuesdayNight:
                degreeValue = Double.parseDouble(TueNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                TueNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.TUE, TueTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusTuesdayNight:
                degreeValue = Double.parseDouble(TueNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                TueNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.TUE, TueTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            /////////////////////// Wednesday
            case R.id.MinusWedDay:
                degreeValue = Double.parseDouble(WedTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                WedTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.WED, String.valueOf(degreeValue), WedNightTemp.getText().toString());
                break;

            case R.id.PlusWedDay:
                degreeValue = Double.parseDouble(WedTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                WedTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.WED, String.valueOf(degreeValue), WedNightTemp.getText().toString());
                break;

            case R.id.MinusWedNight:
                degreeValue = Double.parseDouble(WedNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                WedNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.WED, WedTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusWedNight:
                degreeValue = Double.parseDouble(WedNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                WedNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.WED, WedTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            /////////////////////// Thursday
            case R.id.MinusThuDay:
                degreeValue = Double.parseDouble(ThrTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                ThrTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.THR, String.valueOf(degreeValue), ThrNightTemp.getText().toString());
                break;

            case R.id.PlusThuDay:
                degreeValue = Double.parseDouble(ThrTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                ThrTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.THR, String.valueOf(degreeValue), ThrNightTemp.getText().toString());
                break;

            case R.id.MinusThuNight:
                degreeValue = Double.parseDouble(ThrNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                ThrNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.THR, ThrTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusThuNight:
                degreeValue = Double.parseDouble(ThrNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                ThrNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.THR, ThrTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            /////////////////////// Friday
            case R.id.MinusFriDay:
                degreeValue = Double.parseDouble(FriTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                FriTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.FRI, String.valueOf(degreeValue), FriNightTemp.getText().toString());
                break;

            case R.id.PlusFriDay:
                degreeValue = Double.parseDouble(FriTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                FriTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.FRI, String.valueOf(degreeValue), FriNightTemp.getText().toString());
                break;

            case R.id.MinusFriNight:
                degreeValue = Double.parseDouble(FriNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                FriNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.FRI, FriTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusFriNight:
                degreeValue = Double.parseDouble(FriNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                FriNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.FRI, FriTemp.getText().toString(), String.valueOf(degreeValue));
                break;


            /////////////////////// Saturday
            case R.id.MinusSatDay:
                degreeValue = Double.parseDouble(SatTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                SatTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SAT, String.valueOf(degreeValue), SatNightTemp.getText().toString());
                break;

            case R.id.PlusSatDay:
                degreeValue = Double.parseDouble(SatTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                SatTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SAT, String.valueOf(degreeValue), SatNightTemp.getText().toString());
                break;

            case R.id.MinusSatNight:
                degreeValue = Double.parseDouble(SatNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue--;
                SatNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SAT, SatTemp.getText().toString(), String.valueOf(degreeValue));
                break;

            case R.id.PlusSatNight:
                degreeValue = Double.parseDouble(SatNightTemp.getText().toString());
                if(degreeValue > 90){
                    degreeValue = 75;
                }
                if(degreeValue < 60){
                    degreeValue = 75;
                }
                degreeValue++;
                SatNightTemp.setText(String.valueOf(degreeValue));
                db.updateTempSetting(DBHelper.SAT, SatTemp.getText().toString(), String.valueOf(degreeValue));
                break;


        }
    }

}
