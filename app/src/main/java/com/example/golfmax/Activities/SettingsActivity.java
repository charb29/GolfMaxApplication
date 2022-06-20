package com.example.golfmax.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.User;
import com.example.golfmax.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsActivity extends AppCompatActivity {

    ActionBar actionBar;
    ColorDrawable colorDrawable;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView textViewUsername, textViewChangeEmail, textViewChangePassword, textViewTotalRounds;
    DBHelper db;
    User user;
    long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#013220"));
        actionBar.setBackgroundDrawable(colorDrawable);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Settings");

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navHome:
                        Intent intentHome = new Intent(SettingsActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navLeaderboard:
                        Intent intentLeaderboards = new Intent(SettingsActivity.this, CourseListActivity.class);
                        startActivity(intentLeaderboards);
                        return true;

                    case R.id.navMyScores:
                        Intent intentMyScores = new Intent(SettingsActivity.this, ViewScoresActivity.class);
                        startActivity(intentMyScores);
                        return true;

                    case R.id.navPlayRound:
                        Intent intentPlayRound = new Intent(SettingsActivity.this, PlayRoundActivity.class);
                        startActivity(intentPlayRound);
                        return true;
                }
                return false;
            }
        });

        db = new DBHelper(this);
        user = new User();
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewChangeEmail = findViewById(R.id.textViewChangeEmail);
        textViewChangePassword = findViewById(R.id.textViewChangePassword);
        textViewTotalRounds = findViewById(R.id.textViewTotalRounds);
        user.setId(db.getUserId(LoginActivity.username));
        userId = user.getId();

        ApiClient.getUserService().getUserInfoById(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userInfo = response.body();
                textViewUsername.setText(userInfo.getUsername());
                textViewChangeEmail.setText(userInfo.getEmail());
                textViewChangePassword.setText(userInfo.getPassword());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}