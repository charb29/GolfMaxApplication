package com.example.golfmax.backend;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String MyPREFERENCES = "MyPreferences";
    private static final String USERNAME = "username";
    private SharedPreferences sharedPreferences;
    private static  SharedPreferencesManager instance;

    private SharedPreferencesManager(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences(
                        MyPREFERENCES,
                        Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }

    public void setUsername(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, username);
        editor.apply();
    }

    public String getUsername() {
        String username = sharedPreferences.getString(USERNAME, null);
        return username;
    }
}
