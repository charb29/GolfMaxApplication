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
    private final String ACTION_BAR_TITLE = "Leaderboard";
    private final String ACTION_BAR_COLOR = "#000f00";
    private ActivityCourseLeaderboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        Score score = new Score();
        Course course = new Course();

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_course_leaderboard);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navView = findViewById(R.id.navigation_view_course_leaderboard);

        setDrawerToggleActions(drawerLayout);
        setActionBarTitle(ACTION_BAR_TITLE);
        setActionBarColor(ACTION_BAR_COLOR);
        setNavigationViewIntents(navView);

        course.setCourseName(CourseListRV.staticCourseName);
        score.setCourse(course);
        binding.setScore(score);

        getRecyclerView();
    }

    private void getRecyclerView() {
        long courseId = getCourseIdByCourseName(CourseListRV.staticCourseName);
        List<Score> scoreList = new ArrayList<>();
        ScoreRepository scoreRepository = new ScoreRepository();
        scoreRepository.setScoreList(scoreList);
        scoreRepository.setCourseLeaderboardBinding(binding);
        scoreRepository.getScoresByCourseId(CourseLeaderboardActivity.this, courseId);
    }

    private void removeWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        assert actionBar != null;
        actionBar.setTitle(title);
    }

    private void setActionBarColor(String color) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(color));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    private long getCourseIdByCourseName(String courseName) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);

        Log.i("COURSE NAME ====> ", courseName);
        Log.i("COURSE ID ====> ", String.valueOf(db.getCourseId(courseName)));

        return db.getCourseId(courseName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent goToHomeActivity = new Intent(CourseLeaderboardActivity.this,
                        HomeActivity.class);
                startActivity(goToHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent goToMyScoresActivity = new Intent(CourseLeaderboardActivity.this,
                        PersonalScoresActivity.class);
                startActivity(goToMyScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent goToLeaderboardActivity = new Intent(CourseLeaderboardActivity.this,
                        CourseListActivity.class);
                startActivity(goToLeaderboardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent goToPlayRoundActivity = new Intent(CourseLeaderboardActivity.this,
                        NewRoundActivity.class);
                startActivity(goToPlayRoundActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent goToUserProfileActivity = new Intent(CourseLeaderboardActivity.this,
                        UserProfileActivity.class);
                startActivity(goToUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }
}