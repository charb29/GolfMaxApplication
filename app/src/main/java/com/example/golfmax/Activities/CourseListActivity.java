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
import com.example.golfmax.Models.Course;
import com.example.golfmax.RecyclerViews.CourseListRV;
import com.example.golfmax.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseListActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    CourseListRV courseListRV;
    RecyclerView courseNameRv;
    List<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
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
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        setNavigationView(navigationView);
        populateCourseListRv();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
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
                        Intent intentHome = new Intent(CourseListActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navMyScores:
                        Intent intentMyScores = new Intent(CourseListActivity.this, MyScoresActivity.class);
                        startActivity(intentMyScores);
                        return true;

                    case R.id.navUserProfile:
                        Intent intentSettings = new Intent(CourseListActivity.this, UserProfileActivity.class);
                        startActivity(intentSettings);
                        return true;

                    case R.id.navPlayRound:
                        Intent intentPlayRound = new Intent(CourseListActivity.this, PlayRoundActivity.class);
                        startActivity(intentPlayRound);
                        return true;
                }
                return false;
            }
        });
    }

    private void populateCourseListRv() {
        courseList = new ArrayList<>();
        courseNameRv = (RecyclerView) findViewById(R.id.recycler_view_course_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        courseNameRv.setLayoutManager(layoutManager);

        ApiClient.getUserService().getCourseNames().enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                courseList = response.body();
                Log.i("TAG ====> ", courseList.toString());
                courseListRV = new CourseListRV(getApplicationContext(), courseList);
                courseNameRv.setAdapter(courseListRV);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.e("FAILED ====> ", t.toString());
            }
        });
    }
}