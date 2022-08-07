package com.example.golfmax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.golfmax.backend.CourseRepository;
import com.example.golfmax.models.Course;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityNewRoundBinding;
import com.example.golfmax.models.GolfMaxIntents;
import com.example.golfmax.models.NavigationViewIntents;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewRoundActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private CourseRepository courseRepository;
    private ActivityNewRoundBinding binding;
    private final GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        courseRepository = new CourseRepository();
        binding = DataBindingUtil
                .setContentView(this,  R.layout.activity_new_round);

        setDrawerToggleActions(binding.drawerLayout);
        setActionBarTitle();
        setActionBarColor();
        setNavigationViewIntents(binding.navigationViewPlayRound);
        getRecyclerView();
    }

    private void getRecyclerView() {
        List<Course> courseNamesList = new ArrayList<>();
        courseRepository.setNewRoundBinding(binding);
        courseRepository.setCourseNamesList(courseNamesList);
        courseRepository.getCourseNamesForNewRound(NewRoundActivity.this);
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
        assert actionBar != null;
        actionBar.setTitle("New Round");
    }

    private void setActionBarColor() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return drawerToggle.onOptionsItemSelected(menuItem);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        NavigationViewIntents navigationViewIntents = new NavigationViewIntents
                (this, navigationView, golfMaxIntents);
        navigationViewIntents.setNavigationViewIntents();
    }
}