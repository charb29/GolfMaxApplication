package com.example.golfmax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "userData.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_USERS = "userData";
    private static final String USER_ID = "id";
    private static final String NAME_COL = "name";
    private static final String PASSWORD_COL = "password";
    private static final String EMAIL_COL = "email";
    private static final String TABLE_SCORES = "scoresTable";
    private static final String COURSE_NAME = "courseName";
    private static final String USER_SCORES = "scores";
    private static final String COURSE_RATING = "courseRating";
    private static final String SLOPE_RATING = "slopeRating";
    private static final String SCORE_ID = "id";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user = "CREATE TABLE " + TABLE_USERS + " ("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + EMAIL_COL + " TEXT UNIQUE)";
        db.execSQL(user);

        String userScores = "CREATE TABLE " + TABLE_SCORES + " ("
                + COURSE_NAME + " TEXT UNIQUE, "
                + USER_SCORES + " REAL UNIQUE,"
                + COURSE_RATING + " REAL, "
                + SLOPE_RATING + " REAL, "
                + SCORE_ID + " INTEGER, "
                + " FOREIGN KEY ("+SCORE_ID+") REFERENCES "+TABLE_USERS+" ("+USER_ID+"));";
        db.execSQL(userScores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(db);
    }

    public Boolean addUserInfo(String user, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COL, user);
        contentValues.put(PASSWORD_COL, password);
        contentValues.put(EMAIL_COL, email);
        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkUserPass(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS + " where name = ? and password = ?", new String[] {user, password});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUserEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS + " where email = ?", new String[] {email});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUserInfo(String user, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS + " where name = ? and password = ? and email = ?", new String[] {user, password, email});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void insertScores(String courseName, int userScores, double courseRating, double slopeRating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSE_NAME, courseName);
        contentValues.put(USER_SCORES, userScores);
        contentValues.put(COURSE_RATING, courseRating);
        contentValues.put(SLOPE_RATING, slopeRating);
        db.insert(TABLE_SCORES, null, contentValues);
        db.close();
    }

    public ArrayList<UserScores> readScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SCORES, null);
        ArrayList<UserScores> userScores = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                userScores.add(new UserScores(cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getDouble(2),
                        cursor.getDouble(3)));
            } while(cursor.moveToNext());
        }
        cursor.close();
        return userScores;
    }
}
