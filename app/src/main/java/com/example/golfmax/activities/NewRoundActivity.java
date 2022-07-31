package com.example.golfmax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.golfmax.R;
import com.example.golfmax.backend.CourseRepository;
import com.example.golfmax.databinding.ActivityNewRoundBinding;
import com.example.golfmax.models.Course;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Objects;

public class NewRoundActivity extends AppCompatActivity {

    ActivityNewRoundBinding binding;
    List<Course> courseNamesList;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navView;
    ActionBarDrawerToggle drawerToggle;
    ColorDrawable colorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil
                .setContentView(this,  R.layout.activity_new_round);

        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("New Round");
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navigation_view_play_round);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navOpen, R.string.navClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setNavigationViewIntents(navView);

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.setNewRoundBinding(binding);
        courseRepository.setCourseNamesList(courseNamesList);
        courseRepository.getCourseNamesForNewRound(NewRoundActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent intentHomeActivity = new Intent(NewRoundActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent intentMyScoresActivity = new Intent(NewRoundActivity.this,
                        PersonalScoresActivity.class);
                startActivity(intentMyScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent intentLeaderboardActivity = new Intent(NewRoundActivity.this,
                        CourseListActivity.class);
                startActivity(intentLeaderboardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent intentUserProfileActivity = new Intent(NewRoundActivity.this,
                        UserProfileActivity.class);
                startActivity(intentUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }

}