package com.example.golfmax.activities;

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
import com.example.golfmax.applicationIntents.GolfMaxIntents;
import com.example.golfmax.applicationIntents.NavigationViewIntents;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseListActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private ActivityCourseListBinding binding;
    private final GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        binding = DataBindingUtil
                .setContentView(this,  R.layout.activity_course_list);

        setDrawerToggleActions(binding.drawerLayout);
        setActionBarTitle();
        setActionBarColor();
        setNavigationViewIntents(binding.navigationViewCourseList);
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

    private void setActionBarTitle() {
        actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setTitle("Course List");
    }

    private void setActionBarColor() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        NavigationViewIntents navigationViewIntents = new NavigationViewIntents
                (navigationView, golfMaxIntents);
        navigationViewIntents.setNavigationViewIntents();
    }

}