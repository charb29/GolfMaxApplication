package com.example.golfmax.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Score;
import com.example.golfmax.Models.User;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.ScoresRV;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyScoresActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    List<Score> scoreList;
    ScoresRV scoresRV;
    RecyclerView recyclerView;
    DBHelper db;
    User user;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scores);
        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        long userId = getUserIdByUsername(LoginActivity.username);

        setNavigationView(navigationView);
        getScoresByUserId(userId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private long getUserIdByUsername(String username) {
        db = new DBHelper(this);
        user = new User();
        user.setId(db.getUserId(LoginActivity.username));
        long userId = user.getId();

        return userId;
    }

    private void setNavigationView(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navHome:
                        Intent intentHome = new Intent(MyScoresActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navLeaderboard:
                        Intent intentLeaderboards = new Intent(MyScoresActivity.this, CourseListActivity.class);
                        startActivity(intentLeaderboards);
                        return true;

                    case R.id.navUserProfile:
                        Intent intentSettings = new Intent(MyScoresActivity.this, UserProfileActivity.class);
                        startActivity(intentSettings);
                        return true;

                    case R.id.navPlayRound:
                        Intent intentPlayRound = new Intent(MyScoresActivity.this, PlayRoundActivity.class);
                        startActivity(intentPlayRound);
                        return true;
                }
                return false;
            }
        });
    }

    private void getScoresByUserId(long userId) {
        scoreList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_my_scores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Score>> scoreCall = ApiClient.getUserService().getScoresByUserId(userId);
        scoreCall.enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {
                scoreList = response.body();
                Log.i("TAG ====> ", scoreList.toString());
                scoresRV = new ScoresRV(getApplicationContext(), scoreList);
                recyclerView.setAdapter(scoresRV);
            }

            @Override
            public void onFailure(Call<List<Score>> call, Throwable t) {
                Log.e("FAILED ====> ", t.toString());
            }
        });
    }
}