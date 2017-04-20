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

    public static final String TABLE_LOGIN = "Login";
    public static final String PK_COLUMN_USERNAME = "UserName";
    public static final String COLUMN_PASSWORD = "Password";


    public MainDataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_LOGIN + " (" +
                        PK_COLUMN_USERNAME + " text primary key, " +
                        COLUMN_PASSWORD + " text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(db);
    }

    public boolean insertLoginSetting  (String UserName, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_USERNAME, UserName);
        contentValues.put(COLUMN_PASSWORD, Password);
        db.insert(TABLE_LOGIN, null, contentValues);
        return true;
    }

    public int numberOfRowsLogin(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_LOGIN);
        return numRows;
    }

    public boolean updateLoginSetting (String UserName, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_USERNAME, UserName);
        contentValues.put(COLUMN_PASSWORD, Password);
        db.update(TABLE_LOGIN, contentValues, PK_COLUMN_USERNAME + " = ? ",
                new String[] { UserName } );
        return true;
    }

    public Integer deleteSetting (String UserName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_LOGIN,
                PK_COLUMN_USERNAME + " = ? ",
                new String[] { UserName });
    }

    public ArrayList<HashMap<String, Object>> getLoginSettings(String pkUserName, String pkPassword)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkUserName == null)
            query = "select * from " + TABLE_LOGIN;
        else
            query = "select * from " + TABLE_LOGIN + " where UserName = '" + pkUserName + "' and Password = '" + pkPassword + "'";
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