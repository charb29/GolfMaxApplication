package com.example.golfmax.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.example.golfmax.R;
import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.PlayerStatisticsRepository;
import com.example.golfmax.backend.SharedPreferencesManager;
import com.example.golfmax.databinding.ActivityHomeBinding;
import com.example.golfmax.applicationIntents.GolfMaxIntents;
import com.example.golfmax.models.PlayerStatistics;
import com.example.golfmax.models.User;

public class HomeActivity extends Activity {

    private final PlayerStatisticsRepository playerStatisticsRepository = new PlayerStatisticsRepository();
    private final User user = new User();
    private final PlayerStatistics stats = new PlayerStatistics();
    private final String username = SharedPreferencesManager
            .getInstance(HomeActivity.this)
            .getUsername();
    private final GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);

    @Override
    public void onRestart() {
        super.onRestart();
        long userId = getUserIdByUsername(username);

        user.setId(userId);
        stats.setUser(user);
        playerStatisticsRepository.updateUserStats(stats, user.getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        ActivityHomeBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_home);

        long userId = getUserIdByUsername(username);

        user.setId(userId);
        stats.setUser(user);
        binding.setStats(playerStatisticsRepository.displayStatsSummary(userId));
        playerStatisticsRepository.updateUserStats(stats, user.getId());
    }

    private void removeWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private long getUserIdByUsername(String username) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        return db.getUserId(username);
    }

    public void goToPersonalScoresActivity(View view) {
        golfMaxIntents.goToPersonalScoresActivity();
    }

    public void goToNewRoundActivity(View view) {
        golfMaxIntents.goToPlayRoundActivity();
    }

    public void goToCourseLeaderboardsActivity(View view) {
        golfMaxIntents.goToCourseListActivity();
    }

    public void goToUserProfileActivity(View view) {
        golfMaxIntents.goToUserProfileActivity();
    }
}