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
import android.widget.TextView;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.Models.Score;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.CourseLeaderboardRV;
import com.example.golfmax.RecyclerViews.CourseListRV;
import com.example.golfmax.Requests.CourseRequest;
import com.example.golfmax.Requests.ScoreRequest;
import com.example.golfmax.Responses.ScoreResponse;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseLeaderboardActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    CourseLeaderboardRV courseLeaderboardRV;
    RecyclerView recyclerView;
    List<ScoreResponse> scoreList;
    TextView tvCourseName;
    DBHelper db;
    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_leaderboard);
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

        tvCourseName = findViewById(R.id.text_view_course_name);
        tvCourseName.setText(CourseListRV.courseNameForTextView);
        long courseId = getCourseIdByCourseName(CourseListRV.courseNameForTextView);

        setNavigationView(navigationView);
        populateCourseLeaderBoardRVWithCourseId(courseId);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private long getCourseIdByCourseName(String courseName) {
        db = new DBHelper(this);
        course = new Course();
        course.setId(db.getCourseId(courseName));
        long courseId = course.getId();

        return courseId;
    }

    private void populateCourseLeaderBoardRVWithCourseId(long courseId) {
        scoreList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_course_leaderboard);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Call<List<ScoreResponse>> scoreResponseCall = ApiClient.getUserService().getScoresByCourseId(courseId);
        scoreResponseCall.enqueue(new Callback<List<ScoreResponse>>() {
            @Override
            public void onResponse(Call<List<ScoreResponse>> call, Response<List<ScoreResponse>> response) {
                scoreList = response.body();
                Log.i("TAG ====> ", scoreList.toString());
                courseLeaderboardRV = new CourseLeaderboardRV(getApplicationContext(), scoreList);
                recyclerView.setAdapter(courseLeaderboardRV);
            }

            @Override
            public void onFailure(Call<List<ScoreResponse>> call, Throwable t) {
                Log.e("FAILED ====> ", t.toString());
            }
        });
    }

    private void setNavigationView(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navHome:
                        Intent intentHome = new Intent(CourseLeaderboardActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navMyScores:
                        Intent intentMyScores = new Intent(CourseLeaderboardActivity.this, MyScoresActivity.class);
                        startActivity(intentMyScores);
                        return true;

                    case R.id.navLeaderboard:
                        Intent intentLeaderboards = new Intent(CourseLeaderboardActivity.this, CourseListActivity.class);
                        startActivity(intentLeaderboards);
                        return true;

                    case R.id.navUserProfile:
                        Intent intentSettings = new Intent(CourseLeaderboardActivity.this, UserProfileActivity.class);
                        startActivity(intentSettings);
                        return true;

                    case R.id.navPlayRound:
                        Intent intentPlayRound = new Intent(CourseLeaderboardActivity.this, PlayRoundActivity.class);
                        startActivity(intentPlayRound);
                        return true;
                }
                return false;
            }
        });
    }
}
