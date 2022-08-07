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

import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.ScoreRepository;
import com.example.golfmax.backend.SharedPreferencesManager;
import com.example.golfmax.applicationIntents.GolfMaxIntents;
import com.example.golfmax.applicationIntents.NavigationViewIntents;
import com.example.golfmax.models.Score;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityPersonalScoresBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonalScoresActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private ActivityPersonalScoresBinding binding;
    private final GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_personal_scores);

        setDrawerToggleActions(binding.drawerLayout);
        setActionBarTitle();
        setActionBarColor();
        setNavigationViewIntents(binding.navigationViewPersonalScores);
        getRecyclerView();
    }

    private void getRecyclerView() {
        ScoreRepository scoreRepository = new ScoreRepository();
        List<Score> scoreList = new ArrayList<>();
        scoreRepository.setScoreList(scoreList);
        scoreRepository.setPersonalScoresBinding(binding);
        String username = SharedPreferencesManager
                .getInstance(PersonalScoresActivity.this)
                .getUsername();
        long userId = getUserIdByUsername(username);

        scoreRepository.getScoresByUserId(PersonalScoresActivity.this, userId);
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
        actionBar.setTitle("Personal Scores");
    }

    private void setActionBarColor() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public long getUserIdByUsername(String username) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        return db.getUserId(username);
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