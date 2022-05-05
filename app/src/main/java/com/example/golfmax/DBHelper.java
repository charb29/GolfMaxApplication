package com.example.golfmax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "GolfMax.db";
    private static final int DB_VERSION = 1;

    private static final String DROP_TABLE_IF_USER_EXISTS = "Drop table if exists USERS";
    private static final String DROP_TABLE_IF_SCORES_EXISTS = "Drop table if exists SCORES";
    private static final String CREATE_USER_TABLE_QUERY = """
        CREATE TABLE USERS (
        USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
        USERNAME TEXT,
        PASSWORD TEXT,
        EMAIL TEXT
        )""";
    private static final String CREATE_USER_SCORE_QUERY = """
        CREATE TABLE SCORES (
        COURSE_NAME TEXT,
        SCORE INTEGER,
        COURSE_RATING REAL,
        SLOPE_RATING REAL,
        USER_ID_SCORE INTEGER,
        FOREIGN KEY (USER_ID_SCORE) REFERENCES USERS(USER_ID))
        """;

    // change to parameterized queries to avoid SQL injection //

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE_QUERY);
        db.execSQL(CREATE_USER_SCORE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE_IF_USER_EXISTS);
        db.execSQL(DROP_TABLE_IF_SCORES_EXISTS);
        onCreate(db);
    }

    public Boolean registerUser(String username, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("USERNAME", username);
        values.put("PASSWORD", password);
        values.put("EMAIL", email);
        long result = db.insert("USERS", null, values);
        db.close();

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean validatePasswordEmail(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USERS where username = ? and password = ?", new String[] {username, password});

        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean validateEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USERS where email = ?", new String[] {email});

        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void saveScores(String courseName, int userScores, double courseRating, double slopeRating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("COURSE_NAME", courseName);
        values.put("SCORE", userScores);
        values.put("COURSE_RATING", courseRating);
        values.put("SLOPE_RATING", slopeRating);
        db.insert("SCORES",null, values);
        db.close();
    }

    public ArrayList<UserScores> getScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from SCORES where USER_ID_SCORES = USER_ID", null);
        ArrayList<UserScores> userScores = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                userScores.add(new UserScores(cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userScores;
    }
}