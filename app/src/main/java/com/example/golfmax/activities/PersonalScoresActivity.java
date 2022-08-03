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

import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.ScoreRepository;
import com.example.golfmax.backend.SharedPreferencesManager;
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
    private final String ACTION_BAR_TITLE = "Personal Scores";
    private final String ACTION_BAR_COLOR = "#000f00";
    private ScoreRepository scoreRepository;
    private ActivityPersonalScoresBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_personal_scores);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navView = findViewById(R.id.navigation_view_personal_scores);

        setDrawerToggleActions(drawerLayout);
        setActionBarTitle(ACTION_BAR_TITLE);
        setActionBarColor(ACTION_BAR_COLOR);
        setNavigationViewIntents(navView);
        getRecyclerView();
    }

    private void getRecyclerView() {
        scoreRepository = new ScoreRepository();
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

    private void setActionBarTitle(String title) {
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(title);
    }

    private void setActionBarColor(String color) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(color));
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
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent goToHomeActivity = new Intent(PersonalScoresActivity.this,
                        HomeActivity.class);
                startActivity(goToHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent goToLeaderBoardActivity = new Intent(PersonalScoresActivity.this,
                        CourseListActivity.class);
                startActivity(goToLeaderBoardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent goToPlayRoundActivity = new Intent(PersonalScoresActivity.this,
                        NewRoundActivity.class);
                startActivity(goToPlayRoundActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent goToUserProfileActivity = new Intent(PersonalScoresActivity.this,
                        UserProfileActivity.class);
                startActivity(goToUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }
}