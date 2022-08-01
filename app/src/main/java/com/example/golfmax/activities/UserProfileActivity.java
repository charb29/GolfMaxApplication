package com.example.golfmax.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.PlayerStatisticsRepository;
import com.example.golfmax.backend.SharedPreferencesManager;
import com.example.golfmax.backend.UserRepository;
import com.example.golfmax.contracts.PlayerStatisticsContract;
import com.example.golfmax.models.PlayerStatistics;
import com.example.golfmax.models.User;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityUserProfileBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class UserProfileActivity extends AppCompatActivity implements PlayerStatisticsContract.View {

    private ActionBar actionBar;
    private ActionBarDrawerToggle drawerToggle;
    private ActivityUserProfileBinding binding;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_user_profile);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation_view_user_profile);
        Button btnUpdateUserInfo = findViewById(R.id.button_update_info);

        setDrawerToggleActions(drawerLayout);
        setActionBarTitle("User Profile");
        setActionBarColor("#000f00");
        setNavigationViewIntents(navView);

        PlayerStatisticsRepository playerStatisticsRepository = new PlayerStatisticsRepository();
        userRepository = new UserRepository();

        String username = SharedPreferencesManager.getInstance(UserProfileActivity.this)
                .getUsername();
        long userId = getUserIdByUsername(username);

        Log.i("USER ID ====> ", String.valueOf(userId));

        binding.setUser(userRepository.getUserInfoById(userId));
        binding.setStats(playerStatisticsRepository.displayRoundsPlayed(userId));

        updateUserInfoOnButtonClick(btnUpdateUserInfo);
    }

    private void updateUserInfoOnButtonClick(@NonNull Button button) {
        button.setOnClickListener(v -> {
            User user = new User();

            user.setUsername(binding.getUser().getUsername());
            user.setEmail(binding.getUser().getEmail());
            user.setPassword(binding.getUser().getPassword());
            user.setId(getUserIdByUsername(binding.getUser().getUsername()));

            userRepository.updateUserInfo(user, UserProfileActivity.this);
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (drawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void showData(PlayerStatistics playerStatistics) {}

    private long getUserIdByUsername(String username) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);

        return db.getUserId(username);
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent intentHomeActivity  = new Intent(UserProfileActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent intentCourseListActivity = new Intent(UserProfileActivity.this,
                        CourseListActivity.class);
                startActivity(intentCourseListActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent intentPersonalScoresActivity = new Intent(UserProfileActivity.this,
                        PersonalScoresActivity.class);
                startActivity(intentPersonalScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent intentNewRoundActivity = new Intent(UserProfileActivity.this,
                        NewRoundActivity.class);
                startActivity(intentNewRoundActivity);
                return true;
            } else {
                return false;
            }
        });
    }
}