package com.example.wmschane.projectsample;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FinalProject.db";
    public  static final String STATE_ON = "on";
    public  static final String STATE_OFF = "off";

    public static final String TABLE_ENERGY = "EnergyRoom";
    public static final String PK_COLUMN_ROOM_NAME = "Room";
    public static final String COLUMN_ROOM_STATE = "State";

    public static final String TABLE_APPLIANCES = "EnergyAppliances";
    public static final String PK_COLUMN_APL_NAME = "ApplianceName";
    public static final String COLUMN_APL_STATE = "ApplianceState";

    public static final int DATABASE_VERSION = 7;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_ENERGY + " (" +
                PK_COLUMN_ROOM_NAME + " text primary key, " +
                COLUMN_ROOM_STATE + " text)"
        );

        db.execSQL("create table " + TABLE_APPLIANCES + " (" +
                PK_COLUMN_APL_NAME + " text primary key, " +
                COLUMN_APL_STATE + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPLIANCES);
        onCreate(db);
    }

    public boolean insertEnergySetting  (String room, String on)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_ROOM_NAME, room);
        contentValues.put(COLUMN_ROOM_STATE, on);
        db.insert(TABLE_ENERGY, null, contentValues);
        return true;
    }

    public boolean insertApplianceSetting  (String AplName, String AplSetting)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_APL_NAME, AplName);
        contentValues.put(COLUMN_APL_STATE, AplSetting);
        db.insert(TABLE_APPLIANCES, null, contentValues);
        return true;
    }

    public int numberOfRowsEnergy(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_ENERGY);
        return numRows;
    }

    public int numberOfRowsAppliance(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_APPLIANCES);
        return numRows;
    }

    public boolean updateEnergySetting (String room, String on)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_ROOM_NAME, room);
        contentValues.put(COLUMN_ROOM_STATE, on);
        db.update(TABLE_ENERGY, contentValues, PK_COLUMN_ROOM_NAME + " = ? ",
                new String[] { room } );
        return true;
    }

    public boolean updateApplianceSetting (String AplName, String AplSetting)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_APL_STATE, AplSetting);
        db.update(TABLE_APPLIANCES, contentValues, PK_COLUMN_APL_NAME + " = ? ",
                new String[] { AplName} );
        return true;
    }

    public ArrayList<HashMap<String, Object>> getEnergySettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_ENERGY;
        else
            query = "select * from " + TABLE_ENERGY + " where " + PK_COLUMN_ROOM_NAME + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_ROOM_NAME, res.getString(res.getColumnIndex(PK_COLUMN_ROOM_NAME)));
            map.put(COLUMN_ROOM_STATE, res.getString(res.getColumnIndex(COLUMN_ROOM_STATE)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }

    public ArrayList<HashMap<String, Object>> getApplianceSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_APPLIANCES;
        else
            query = "select * from " + TABLE_APPLIANCES + " where " + PK_COLUMN_APL_NAME + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_APL_NAME, res.getString(res.getColumnIndex(PK_COLUMN_APL_NAME)));
            map.put(COLUMN_APL_STATE,res.getString(res.getColumnIndex(COLUMN_APL_STATE)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}