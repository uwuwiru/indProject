package com.example.individualproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB {

    private static final String DATABASE_NAME = "modes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Modes";

    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_COLOR1 = "Color1";
    private static final String COLUMN_COLOR2 = "Color2";
    private static final String COLUMN_COLOR3 = "Color3";
    private static final String COLUMN_TEMP1 = "Temp1";
    private static final String COLUMN_TEMP2 = "Temp2";
    private static final String COLUMN_TEMP3 = "Temp3";


    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME = 1;
    private static final int NUM_COLUMN_COLOR1 = 2;
    private static final int NUM_COLUMN_COLOR2 = 3;
    private static final int NUM_COLUMN_COLOR3 = 4;
    private static final int NUM_COLUMN_TEMP1 = 5;
    private static final int NUM_COLUMN_TEMP2 = 6;
    private static final int NUM_COLUMN_TEMP3 = 7;

    private static SQLiteDatabase db;

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_COLOR1 + " TEXT NOT NULL, " +
                    COLUMN_COLOR2 + " TEXT NOT NULL, " +
                    COLUMN_COLOR3 + " TEXT NOT NULL, " +
                    COLUMN_TEMP1 + " INTEGER NOT NULL, " +
                    COLUMN_TEMP2 + " INTEGER NOT NULL, " +
                    COLUMN_TEMP3 + " INTEGER NOT NULL);";
            sqLiteDatabase.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);

        }
    }

    public DB(Context context){
        OpenHelper helper = new OpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public long insert(String name,String color1, String color2, String color3, int temp1, int temp2,int temp3) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_COLOR1, color1);
        cv.put(COLUMN_COLOR2, color2);
        cv.put(COLUMN_COLOR3, color3);
        cv.put(COLUMN_TEMP1, temp1);
        cv.put(COLUMN_TEMP2, temp2);
        cv.put(COLUMN_TEMP3, temp3);
        return db.insert(TABLE_NAME, null, cv);
    }

    public long update(int id, String name,String color1, String color2, String color3, int temp1, int temp2,int temp3) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_COLOR1, color1);
        cv.put(COLUMN_COLOR2, color2);
        cv.put(COLUMN_COLOR3, color3);
        cv.put(COLUMN_TEMP1, temp1);
        cv.put(COLUMN_TEMP2, temp2);
        cv.put(COLUMN_TEMP3, temp3);
        String names[] = new String[] {"\"" + name + "\""};
        return db.update(TABLE_NAME, cv, COLUMN_NAME +" = ?", names);
    }

    public boolean delete(String name) {
        return (db.delete(TABLE_NAME, COLUMN_NAME + "= \"" + name + "\"", null)>0);
    }

    public static ArrayList<Mode> selectAll() {
        Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Mode> arr = new ArrayList<>();
        mCursor.moveToFirst();
        if (!mCursor.isAfterLast()) {
            do {
                int id = mCursor.getInt(NUM_COLUMN_ID);
                String name = mCursor.getString(NUM_COLUMN_NAME);
                String color1_s = mCursor.getString(NUM_COLUMN_COLOR1);
                String color2_s = mCursor.getString(NUM_COLUMN_COLOR2);
                String color3_s = mCursor.getString(NUM_COLUMN_COLOR3);

                int temp1 = mCursor.getInt(NUM_COLUMN_TEMP1);
                int temp2 = mCursor.getInt(NUM_COLUMN_TEMP2);
                int temp3 = mCursor.getInt(NUM_COLUMN_TEMP3);
                arr.add(new Mode(name, MyColor.fromString(color1_s), MyColor.fromString(color2_s), MyColor.fromString(color3_s), temp1, temp2, temp3));
            } while (mCursor.moveToNext());
        }
        return arr;
    }
}

