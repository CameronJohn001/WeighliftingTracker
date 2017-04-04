package com.example.cameron.weighliftingtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "liftsDB.db";
    public static final String TABLE_LIFTS = "lifts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LIFTNAME = "liftname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_LIFTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LIFTNAME + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIFTS);
        onCreate(db);
    }
    //Add a new row to the database
    public void addLift(LiftsDB lift){
        ContentValues values = new ContentValues();
        values.put(COLUMN_LIFTNAME, lift.get_liftname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LIFTS, null, values);
        db.close();
    }
    //Delete a product from the database
    public void deleteLift(String liftName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LIFTS + " WHERE " + COLUMN_LIFTNAME + "=\"" + liftName + "\";");
    }
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_LIFTS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();
        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("liftname")) != null) {
                dbString += c.getString(c.getColumnIndex("liftname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}