package com.example.golfmax.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.backend.CourseRepository;
import com.example.golfmax.models.Course;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityCourseListBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseListActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private final String ACTION_BAR_TITLE = "Course List";
    private final String ACTION_BAR_COLOR = "#000f00";
    private  ActivityCourseListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        binding = DataBindingUtil
                .setContentView(this,  R.layout.activity_course_list);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navView = findViewById(R.id.navigation_view_course_list);

        setDrawerToggleActions(drawerLayout);
        setActionBarTitle(ACTION_BAR_TITLE);
        setActionBarColor(ACTION_BAR_COLOR);
        setNavigationViewIntents(navView);
        getRecyclerView();
    }

    private void getRecyclerView() {
        CourseRepository courseRepository = new CourseRepository();
        List<Course> courseNamesList = new ArrayList<>();
        courseRepository.setCourseNamesList(courseNamesList);
        courseRepository.setCourseListBinding(binding);
        courseRepository.getCourseNamesForLeaderboard(CourseListActivity.this);
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
        Objects.requireNonNull(actionBar).setTitle(title);
    }

    private void setActionBarColor(String color) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(color));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent intentHomeActivity = new Intent(CourseListActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent intentMyScoresActivity = new Intent(CourseListActivity.this,
                        PersonalScoresActivity.class);
                startActivity(intentMyScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent intentPlayRoundActivity = new Intent(CourseListActivity.this,
                        NewRoundActivity.class);
                startActivity(intentPlayRoundActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent intentUserProfileActivity = new Intent(CourseListActivity.this,
                        UserProfileActivity.class);
                startActivity(intentUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }

}