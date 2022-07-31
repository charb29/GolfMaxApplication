package com.example.golfmax.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.ScoreRepository;
import com.example.golfmax.models.Course;
import com.example.golfmax.models.Score;
import com.example.golfmax.recyclerViews.CourseListRV;

import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityCourseLeaderboardBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseLeaderboardActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityCourseLeaderboardBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_course_leaderboard);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navView = findViewById(R.id.navigation_view_course_leaderboard);

        setDrawerToggleActions(drawerLayout);
        setActionBarTitle("Leaderboard");
        setActionBarColor("#000f00");
        setNavigationViewIntents(navView);

        ScoreRepository scoreRepository = new ScoreRepository();
        Score score = new Score();
        Course course = new Course();
        List<Score> scoreList = new ArrayList<>();

        scoreRepository.setScoreList(scoreList);
        scoreRepository.setCourseLeaderboardBinding(binding);
        long courseId = getCourseId(CourseListRV.staticCourseName);
        course.setCourseName(CourseListRV.staticCourseName);

        scoreRepository.getScoresByCourseId(CourseLeaderboardActivity.this, courseId);
        score.setCourse(course);
        binding.setScore(score);
    }

    private void setDrawerToggleActions(DrawerLayout drawerLayout) {
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                R.string.navOpen, R.string.navClose );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void setActionBarTitle(String title) {
        actionBar = getSupportActionBar();
        actionBar.setTitle(title);
    }

    private void setActionBarColor(String color) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(color));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    private long getCourseId(String courseName) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        long courseId = db.getCourseId(courseName);

        Log.i("COURSE NAME ====> ", courseName);
        Log.i("COURSE ID ====> ", String.valueOf(courseId));

        return courseId;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent intentHomeActivity = new Intent(CourseLeaderboardActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent intentMyScoresActivity = new Intent(CourseLeaderboardActivity.this,
                        PersonalScoresActivity.class);
                startActivity(intentMyScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent intentLeaderBoardActivity = new Intent(CourseLeaderboardActivity.this,
                        CourseListActivity.class);
                startActivity(intentLeaderBoardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent intentPlayRoundActivity = new Intent(CourseLeaderboardActivity.this,
                        NewRoundActivity.class);
                startActivity(intentPlayRoundActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent intentUserProfileActivity = new Intent(CourseLeaderboardActivity.this,
                        UserProfileActivity.class);
                startActivity(intentUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }
}