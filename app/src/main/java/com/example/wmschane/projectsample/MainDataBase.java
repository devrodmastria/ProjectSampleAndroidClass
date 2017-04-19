package com.example.wmschane.projectsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MainDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Login.db";
    public static final String TABLE_NAME = "Login";
    public static final String PK_COLUMN_USERNAME = "UserName";
    public static final String COLUMN_PASSWORD = "Password";


    public MainDataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_NAME + " (" +
                        PK_COLUMN_USERNAME + " text primary key, " +
                        COLUMN_PASSWORD + " text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSetting  (String UserName, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_USERNAME, UserName);
        contentValues.put(COLUMN_PASSWORD, Password);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateSetting (String UserName, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_USERNAME, UserName);
        contentValues.put(COLUMN_PASSWORD, Password);
        db.update(TABLE_NAME, contentValues, PK_COLUMN_USERNAME + " = ? ",
                new String[] { UserName } );
        return true;
    }

    public Integer deleteSetting (String UserName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                PK_COLUMN_USERNAME + " = ? ",
                new String[] { UserName });
    }

    public ArrayList<HashMap<String, Object>> getSettings(String pkUserName, String pkPassword)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkUserName == null)
            query = "select * from " + TABLE_NAME;
        else
            query = "select * from " + TABLE_NAME + " where UserName = '" + pkUserName + "' and Password = '" + pkPassword + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();

        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_USERNAME, res.getString(res.getColumnIndex(PK_COLUMN_USERNAME)));
            map.put(COLUMN_PASSWORD,res.getString(res.getColumnIndex(COLUMN_PASSWORD)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}