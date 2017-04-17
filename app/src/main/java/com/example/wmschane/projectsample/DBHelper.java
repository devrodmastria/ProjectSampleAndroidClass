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

    public static final String DATABASE_NAME = "project.db";
    public static final String TABLE_NAME = "settings";
    public static final String PK_COLUMN_ROOM_NAME = "room";
    public static final String COLUMN_CHECKBOX_NAME = "checkbox";
    public static final String COLUMN_CONTEXT_NAME = "context";
    public static final int DATABASE_VERSION = 4;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean res;
        db.execSQL("create table " + TABLE_NAME + " (" +
                PK_COLUMN_ROOM_NAME + " text primary key, " +
                COLUMN_CHECKBOX_NAME + " text, " +
                COLUMN_CONTEXT_NAME + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSetting  (String room, boolean checkbox, String on)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_ROOM_NAME, room);

        if (checkbox)contentValues.put(COLUMN_CHECKBOX_NAME, "true");
        else contentValues.put(COLUMN_CHECKBOX_NAME, "false");

        contentValues.put(COLUMN_CONTEXT_NAME, on);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateSetting (String room, boolean checkbox, String on)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_ROOM_NAME, room);
        if (checkbox)contentValues.put(COLUMN_CHECKBOX_NAME, "true");
        else contentValues.put(COLUMN_CHECKBOX_NAME, "false");
        contentValues.put(COLUMN_CONTEXT_NAME, on);
        db.update(TABLE_NAME, contentValues, PK_COLUMN_ROOM_NAME + " = ? ",
                new String[] { room } );
        return true;
    }

    public Integer deleteSetting (String room)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                PK_COLUMN_ROOM_NAME + " = ? ",
                new String[] { room });
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

            map.put(PK_COLUMN_ROOM_NAME, res.getString(res.getColumnIndex(PK_COLUMN_ROOM_NAME)));
            if (res.getString(res.getColumnIndex(COLUMN_CHECKBOX_NAME)).equals("true"))
                map.put(COLUMN_CHECKBOX_NAME,true);
            else
                map.put(COLUMN_CHECKBOX_NAME,false);
            map.put(COLUMN_CONTEXT_NAME,res.getString(res.getColumnIndex(COLUMN_CONTEXT_NAME)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}