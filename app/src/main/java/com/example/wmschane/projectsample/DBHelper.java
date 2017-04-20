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
    public  static final String SUN = "Sunday";
    public  static final String MON = "Monday";
    public  static final String TUE = "Tuesday";
    public  static final String WED = "Wednesday";
    public  static final String THR = "Thursday";
    public  static final String FRI = "Friday";
    public  static final String SAT = "Saturday";

    public static final String TABLE_LOGIN = "Login";
    public static final String PK_COLUMN_USERNAME = "UserName";
    public static final String COLUMN_PASSWORD = "Password";

    public static final String TABLE_ENERGY = "EnergyRoom";
    public static final String PK_COLUMN_ROOM_NAME = "Room";
    public static final String COLUMN_ROOM_STATE = "State";

    public static final String TABLE_APPLIANCES = "EnergyAppliances";
    public static final String PK_COLUMN_APL_NAME = "ApplianceName";
    public static final String COLUMN_APL_STATE = "ApplianceState";

    public static final String TABLE_TEMP = "EnergyTemp";
    public static final String PK_COLUMN_DAY_OF_WEEK = "DOW"; // used for both temperature and admin fragments
    public static final String COLUMN_DAY = "Day";
    public static final String COLUMN_NIGHT = "Night";

    public static final String TABLE_ACCESS = "Protection";
    public static final String PK_COLUMN_AREA = "Area";
    public static final String COLUMN_STATUS = "Status";

    public static final String TABLE_ADMIN_HEALTH = "AdminHealth";
    public static final String COLUMN_ON_TIME = "armOn";
    public static final String COLUMN_OFF_TIME = "armOff";

    public static final String TABLE_ADMIN_ENERGY = "AdminEnergy";

    public static final String TABLE_ADMIN_PROTECTION = "AdminProtection";

    public static final int DATABASE_VERSION = 14;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_LOGIN + " (" +
                PK_COLUMN_USERNAME + " text primary key, " +
                COLUMN_PASSWORD + " text )"
        );

        db.execSQL("create table " + TABLE_ENERGY + " (" +
                PK_COLUMN_ROOM_NAME + " text primary key, " +
                COLUMN_ROOM_STATE + " text)"
        );

        db.execSQL("create table " + TABLE_APPLIANCES + " (" +
                PK_COLUMN_APL_NAME + " text primary key, " +
                COLUMN_APL_STATE + " text)"
        );

        db.execSQL("create table " + TABLE_TEMP + " (" +
                PK_COLUMN_DAY_OF_WEEK + " text primary key, " +
                COLUMN_DAY + " text, " +
                COLUMN_NIGHT + " text)"
        );

        db.execSQL("create table " + TABLE_ACCESS + " (" +
                PK_COLUMN_AREA + " text primary key, " +
                COLUMN_STATUS + " text)"
        );

        db.execSQL("create table " + TABLE_ADMIN_HEALTH + " (" +
                PK_COLUMN_DAY_OF_WEEK + " text primary key, " +
                COLUMN_ON_TIME + " text, " +
                COLUMN_OFF_TIME + " text)"
        );

        db.execSQL("create table " + TABLE_ADMIN_ENERGY + " (" +
                PK_COLUMN_DAY_OF_WEEK + " text primary key, " +
                COLUMN_ON_TIME + " text, " +
                COLUMN_OFF_TIME + " text)"
        );

        db.execSQL("create table " + TABLE_ADMIN_PROTECTION + " (" +
                PK_COLUMN_DAY_OF_WEEK + " text primary key, " +
                COLUMN_ON_TIME + " text, " +
                COLUMN_OFF_TIME + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPLIANCES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN_HEALTH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN_ENERGY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN_PROTECTION);
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

    public boolean insertTempSetting  (String DayOfWeek, String Day, String Night)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_DAY_OF_WEEK, DayOfWeek);
        contentValues.put(COLUMN_DAY, Day);
        contentValues.put(COLUMN_NIGHT, Night);
        db.insert(TABLE_TEMP, null, contentValues);
        return true;
    }

    public boolean insertAccessSetting  (String Area, String Status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_AREA, Area);
        contentValues.put(COLUMN_STATUS, Status);
        db.insert(TABLE_ACCESS, null, contentValues);
        return true;
    }

    public boolean insertAdmHealthSetting  (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_DAY_OF_WEEK, DayOfWeek);
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.insert(TABLE_ADMIN_HEALTH, null, contentValues);
        return true;
    }

    public boolean insertAdmEnergySetting  (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_DAY_OF_WEEK, DayOfWeek);
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.insert(TABLE_ADMIN_ENERGY, null, contentValues);
        return true;
    }

    public boolean insertAdmProtectSetting  (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_DAY_OF_WEEK, DayOfWeek);
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.insert(TABLE_ADMIN_PROTECTION, null, contentValues);
        return true;
    }

    public int numberOfRowsLogin(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_LOGIN);
        return numRows;
    }

    public int numberOfRowsEnergy(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_ENERGY);
    }

    public int numberOfRowsAppliance(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_APPLIANCES);
    }

    public int numberOfRowsTemp(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_TEMP);
    }

    public int numberOfRowsAccess(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_ACCESS);
    }

    public int numberOfRowsAdmHealth(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_ADMIN_HEALTH);
    }

    public int numberOfRowsAdmEnergy(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_ADMIN_ENERGY);
    }

    public int numberOfRowsAdmProtect(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_ADMIN_PROTECTION);
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

    public boolean updateTempSetting (String DayOfWeek, String Day, String Night)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DAY, Day);
        contentValues.put(COLUMN_NIGHT, Night);
        db.update(TABLE_TEMP, contentValues, PK_COLUMN_DAY_OF_WEEK + " = ? ",
                new String[] { DayOfWeek } );
        return true;
    }

    public boolean updateAccessSetting (String Area, String Status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PK_COLUMN_AREA, Area);
        contentValues.put(COLUMN_STATUS, Status);
        db.update(TABLE_ACCESS, contentValues, PK_COLUMN_AREA + " = ? ",
                new String[] { Area } );
        return true;
    }

    public boolean updateAdmHealthSetting (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.update(TABLE_ADMIN_HEALTH, contentValues, PK_COLUMN_DAY_OF_WEEK + " = ? ",
                new String[] { DayOfWeek } );
        return true;
    }

    public boolean updateAdmEnergySetting (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.update(TABLE_ADMIN_ENERGY, contentValues, PK_COLUMN_DAY_OF_WEEK + " = ? ",
                new String[] { DayOfWeek } );
        return true;
    }

    public boolean updateAdmProtectSetting (String DayOfWeek, String on, String off)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ON_TIME, on);
        contentValues.put(COLUMN_OFF_TIME, off);
        db.update(TABLE_ADMIN_PROTECTION, contentValues, PK_COLUMN_DAY_OF_WEEK + " = ? ",
                new String[] { DayOfWeek } );
        return true;
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

    public ArrayList<HashMap<String, Object>> getTempSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_TEMP;
        else
            query = "select * from " + TABLE_TEMP + " where " + PK_COLUMN_DAY_OF_WEEK + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_DAY_OF_WEEK, res.getString(res.getColumnIndex(PK_COLUMN_DAY_OF_WEEK)));
            map.put(COLUMN_DAY,res.getString(res.getColumnIndex(COLUMN_DAY)));
            map.put(COLUMN_NIGHT,res.getString(res.getColumnIndex(COLUMN_NIGHT)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }

    public ArrayList<HashMap<String, Object>> getAccessSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_ACCESS;
        else
            query = "select * from " + TABLE_ACCESS + " where " + PK_COLUMN_AREA + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_AREA, res.getString(res.getColumnIndex(PK_COLUMN_AREA)));
            map.put(COLUMN_STATUS,res.getString(res.getColumnIndex(COLUMN_STATUS)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }

    public ArrayList<HashMap<String, Object>> getAdmHealthSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_ADMIN_HEALTH;
        else
            query = "select * from " + TABLE_ADMIN_HEALTH + " where " + PK_COLUMN_DAY_OF_WEEK + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_DAY_OF_WEEK, res.getString(res.getColumnIndex(PK_COLUMN_DAY_OF_WEEK)));
            map.put(COLUMN_ON_TIME,res.getString(res.getColumnIndex(COLUMN_ON_TIME)));
            map.put(COLUMN_OFF_TIME,res.getString(res.getColumnIndex(COLUMN_OFF_TIME)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }

    public ArrayList<HashMap<String, Object>> getAdmEnergySettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_ADMIN_ENERGY;
        else
            query = "select * from " + TABLE_ADMIN_ENERGY + " where " + PK_COLUMN_DAY_OF_WEEK + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_DAY_OF_WEEK, res.getString(res.getColumnIndex(PK_COLUMN_DAY_OF_WEEK)));
            map.put(COLUMN_ON_TIME,res.getString(res.getColumnIndex(COLUMN_ON_TIME)));
            map.put(COLUMN_OFF_TIME,res.getString(res.getColumnIndex(COLUMN_OFF_TIME)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }

    public ArrayList<HashMap<String, Object>> getAdmProtectSettings(String pkVal)
    {
        ArrayList<HashMap<String, Object>> settings_list = new ArrayList<>();
        HashMap<String, Object> map;
        String query;

        SQLiteDatabase db = this.getReadableDatabase();
        if (pkVal == null)
            query = "select * from " + TABLE_ADMIN_PROTECTION;
        else
            query = "select * from " + TABLE_ADMIN_PROTECTION + " where " + PK_COLUMN_DAY_OF_WEEK + " = '" + pkVal + "'";
        Cursor res =  db.rawQuery(query, null);
        res.moveToFirst();

        map = new HashMap<>();
        while(res.isAfterLast() == false){

            map.put(PK_COLUMN_DAY_OF_WEEK, res.getString(res.getColumnIndex(PK_COLUMN_DAY_OF_WEEK)));
            map.put(COLUMN_ON_TIME,res.getString(res.getColumnIndex(COLUMN_ON_TIME)));
            map.put(COLUMN_OFF_TIME,res.getString(res.getColumnIndex(COLUMN_OFF_TIME)));
            settings_list.add(map);
            res.moveToNext();
        }
        return settings_list;
    }
}