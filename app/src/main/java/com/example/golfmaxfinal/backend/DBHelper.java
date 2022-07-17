package com.example.golfmaxfinal.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "scores.db";
    private static final int version = 1;
    private static final String userTable = "userScores";
    private static final String userId = "id";
    private static final String user = "username";
    private static final String createUserTable = "CREATE TABLE " + userTable + " ("
            + userId + " REAL,"
            + user + " TEXT)";
    private static final String dropUserTable = "DROP TABLE IF EXISTS " + userTable;

    private static final String courseTable = "courses";
    private static final String course = "courseName";
    private static final String courseId = "id";
    private static final String createCourseTable = "CREATE TABLE " + courseTable + " ("
            + courseId + " REAL,"
            + course + " TEXT)";
    private static final String dropCourseTable = "DROP TABLE IF EXISTS " + courseTable;

    public DBHelper(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable);
        db.execSQL(createCourseTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropUserTable);
        db.execSQL(dropCourseTable);
        onCreate(db);
    }

    public long saveUser(String username, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userId, id);
        contentValues.put(user, username);

        Log.i("DB SAVED USER > ", "username: " + username + " " + "id: " + id);

        long result = db.insert(userTable, null, contentValues);

        return result;
    }

    public long getUserId(String username) {
        Log.i("DB USERNAME ====> ", username);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM userScores WHERE username = ?", new String[] {username});
        long id = -1;

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getLong(0);
            } while (cursor.moveToNext());
        }
        Log.i("DB USER ID ====> ", String.valueOf(id));
        cursor.close();

        return id;
    }

    public long saveCourse(String courseName, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(courseId, id);
        contentValues.put(course, courseName);

        long result = db.insert(courseTable, null, contentValues);
        return result;
    }

    public long getCourseId(String courseName) {
        Log.i("DB COURSE NAME ====> ", courseName);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM courses WHERE courseName = ?", new String[] {courseName});
        long id = -1;

        if (cursor.moveToFirst()) {
            id = cursor.getLong(0);
            cursor.close();
        }
        db.close();

        return id;
    }
}
