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
import com.example.golfmax.models.Score;
import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.databinding.ActivityPersonalScoresBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Objects;

public class PersonalScoresActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navView;
    ActionBarDrawerToggle drawerToggle;
    ColorDrawable colorDrawable;
    List<Score> scoreList;
    ActivityPersonalScoresBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_personal_scores);

        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Personal Scores");
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navigation_view_personal_scores);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navOpen, R.string.navClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setNavigationViewIntents(navView);

        ScoreRepository scoreRepository = new ScoreRepository();

        scoreRepository.setScoreList(scoreList);
        scoreRepository.setPersonalScoresBinding(binding);
        long userId = getUserId(LoginActivity.staticUsername);

        scoreRepository.getScoresByUserId(PersonalScoresActivity.this, userId);
    }

    public long getUserId(String username) {
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
                Intent intentHomeActivity = new Intent(PersonalScoresActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent intentLeaderBoardActivity = new Intent(PersonalScoresActivity.this,
                        CourseListActivity.class);
                startActivity(intentLeaderBoardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent intentPlayRoundActivity = new Intent(PersonalScoresActivity.this,
                        NewRoundActivity.class);
                startActivity(intentPlayRoundActivity);
                return true;
            }
            if (item.getItemId() == R.id.navUserProfile) {
                Intent intentUserProfileActivity = new Intent(PersonalScoresActivity.this,
                        UserProfileActivity.class);
                startActivity(intentUserProfileActivity);
                return true;
            } else {
                return false;
            }
        });
    }
}