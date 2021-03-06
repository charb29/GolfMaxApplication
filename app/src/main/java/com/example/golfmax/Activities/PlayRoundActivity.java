package com.example.golfmax.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Models.Course;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.PlayRoundRV;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayRoundActivity extends AppCompatActivity {

    List<Course> courseList;
    PlayRoundRV playRoundRV;
    RecyclerView courseNameRV;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_round);
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

        setNavigationView(navigationView);
        populateCourseNameRV();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void setNavigationView(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navHome:
                        Intent intentHome = new Intent(PlayRoundActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navLeaderboard:
                        Intent intentLeaderboards = new Intent(PlayRoundActivity.this, CourseListActivity.class);
                        startActivity(intentLeaderboards);
                        return true;

                    case R.id.navUserProfile:
                        Intent intentSettings = new Intent(PlayRoundActivity.this, UserProfileActivity.class);
                        startActivity(intentSettings);
                        return true;

                    case R.id.navMyScores:
                        Intent intentMyScores = new Intent(PlayRoundActivity.this, MyScoresActivity.class);
                        startActivity(intentMyScores);
                        return true;
                }
                return false;
            }
        });
    }

    private void populateCourseNameRV() {
        courseList = new ArrayList<>();
        courseNameRV = (RecyclerView) findViewById(R.id.recycler_view_course_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        courseNameRV.setLayoutManager(layoutManager);

        Call<List<Course>> courseCall = ApiClient.getUserService().getCourseNames();
        courseCall.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                courseList = response.body();
                Log.i("TAG ====> ", courseList.toString());
                playRoundRV = new PlayRoundRV(getApplicationContext(), courseList);
                courseNameRV.setAdapter(playRoundRV);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.e("FAILED ====> ", t.toString());
            }
        });
    }
}