package com.example.golfmax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "scores.db";
    private static final int version = 1;
    private static final String tableName = "userScores";
    private static final String userId = "id";
    private static final String user = "username";
    private static final String createTable = "CREATE TABLE " + tableName + " ("
            + userId + " REAL,"
            + user + " TEXT)";

    private static final String dropTable = "DROP TABLE IF EXISTS " + tableName;

    public DBHelper(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropTable);
        onCreate(db);
    }

    public long saveUser(String username, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userId, id);
        contentValues.put(user, username);

        long result = db.insert(tableName, null, contentValues);
        return result;
    }

    public long getUserId(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM userScores WHERE username = ?", new String[] {username});
        long id = -1;
        if (cursor.moveToFirst()) {
            id = cursor.getLong(0);
            cursor.close();
        }
        db.close();
        return id;
    }
}
