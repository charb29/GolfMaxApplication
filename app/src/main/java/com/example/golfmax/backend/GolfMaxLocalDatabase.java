package com.example.golfmax.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;

public class GolfMaxLocalDatabase extends SQLiteOpenHelper {

    private static final String dbName = "scores.db";
    private static final int version = 1;
    private static final String userTable = "userScores";
    private static final String userId = "id";
    private static final String user = "username";
    private static final String dropUserTable = "DROP TABLE IF EXISTS " + userTable;
    private static final String createUserTable = "CREATE TABLE "
            + userTable + " ("
            + userId + " REAL,"
            + user + " TEXT)";

    private static final String courseTable = "courses";
    private static final String course = "courseName";
    private static final String courseId = "id";
    private static final String dropCourseTable = "DROP TABLE IF EXISTS " + courseTable;
    private static final String createCourseTable = "CREATE TABLE "
            + courseTable + " ("
            + courseId + " REAL,"
            + course + " TEXT)";

    public GolfMaxLocalDatabase(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(createUserTable);
        db.execSQL(createCourseTable);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropUserTable);
        db.execSQL(dropCourseTable);
        onCreate(db);
    }

    public void saveUser(String username, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userId, id);
        contentValues.put(user, username);

        Log.i("DB SAVED USER ====> ", "username: " + username + " " + "id: " + id);

        db.insert(userTable, null, contentValues);
    }

    public long getUserId(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM userScores WHERE username = ?",
                new String[] {username});
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

    public void saveCourse(String courseName, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(courseId, id);
        contentValues.put(course, courseName);
        db.insert(courseTable, null, contentValues);
    }

    public long getCourseId(@NonNull String courseName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery
                ("SELECT id FROM courses WHERE courseName = ?", new String[] {courseName});
        long id = -1;
        if (cursor.moveToFirst())
            do {
                id = cursor.getLong(0);
            } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return id;
    }
}
