package com.example.wmschane.projectsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class AppliancesDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Appliances.db";
    public static final String TABLE_NAME = "EnergyAppliances";
    public static final String PK_COLUMN_APL_NAME = "ApplianceName";
    public static final String COLUMN_APL_SETTING = "ApplianceSetting";

    public AppliancesDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_NAME + " (" +
                PK_COLUMN_APL_NAME + " text primary key, " +
                COLUMN_APL_SETTING + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSetting  (String AplName, String AplSetting)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_APL_NAME, AplName);
        contentValues.put(COLUMN_APL_SETTING, AplSetting);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateSetting (String AplName, String AplSetting)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_APL_SETTING, AplSetting);
        db.update(TABLE_NAME, contentValues, PK_COLUMN_APL_NAME + " = ? ",
                new String[] { AplName} );
        return true;
    }

    public Integer deleteSetting (String AplName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                PK_COLUMN_APL_NAME + " = ? ",
                new String[] { AplName });
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

            map.put(PK_COLUMN_APL_NAME, res.getString(res.getColumnIndex(PK_COLUMN_APL_NAME)));
            map.put(COLUMN_APL_SETTING,res.getString(res.getColumnIndex(COLUMN_APL_SETTING)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}