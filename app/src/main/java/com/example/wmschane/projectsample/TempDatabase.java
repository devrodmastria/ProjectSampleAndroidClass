package com.example.wmschane.projectsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class TempDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FinalProject.db";
    public static final String TABLE_NAME = "EnergyTemp";
    public static final String PK_COLUMN_DAYOFWEEK = "DOW";
    public static final String COLUMN_DATETIME = "Day";
    public static final String COLUMN_NIGHTTIME = "Night";

    public TempDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_NAME + " (" +
                        PK_COLUMN_DAYOFWEEK + " text primary key, " +
                        COLUMN_DATETIME + " text, " +
                        COLUMN_NIGHTTIME + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSetting  (String DayOfWeek, String Day, String Night)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_DAYOFWEEK, DayOfWeek);
        contentValues.put(COLUMN_DATETIME, Day);
        contentValues.put(COLUMN_NIGHTTIME, Night);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateSetting (String DayOfWeek, String Day, String Night)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATETIME, Day);
        contentValues.put(COLUMN_NIGHTTIME, Night);
        db.update(TABLE_NAME, contentValues, PK_COLUMN_DAYOFWEEK + " = ? ",
                new String[] { DayOfWeek } );
        return true;
    }

    public Integer deleteSetting (String DayOfWeek)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                PK_COLUMN_DAYOFWEEK + " = ? ",
                new String[] { DayOfWeek });
    }

    public ArrayList<HashMap<String, Object>> getSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_NAME;
        else
            query = "select * from " + TABLE_NAME + " where room = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        while(res.isAfterLast() == false){

            map = new HashMap<>();

            map.put(PK_COLUMN_DAYOFWEEK, res.getString(res.getColumnIndex(PK_COLUMN_DAYOFWEEK)));
            map.put(COLUMN_DATETIME,res.getString(res.getColumnIndex(COLUMN_DATETIME)));
            map.put(COLUMN_NIGHTTIME,res.getString(res.getColumnIndex(COLUMN_NIGHTTIME)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}