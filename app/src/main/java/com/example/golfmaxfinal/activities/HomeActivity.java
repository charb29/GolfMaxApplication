package com.example.golfmaxfinal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiCallMethods;
import com.example.golfmaxfinal.backend.DBHelper;
import com.example.golfmaxfinal.contracts.PlayerStatisticsContract;
import com.example.golfmaxfinal.databinding.ActivityHomeBinding;
import com.example.golfmaxfinal.models.PlayerStatistics;

public class HomeActivity extends Activity implements PlayerStatisticsContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ApiCallMethods apiCall = new ApiCallMethods();
        ActivityHomeBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_home);

        long userId = getUserIdByUsername(LoginActivity.username);

        binding.setStats(apiCall.displayStatsSummary(userId));
    }

    @Override
    public void showData(PlayerStatistics playerStatistics) {}

    public long getUserIdByUsername(String username) {
        DBHelper db = new DBHelper(this);

        return db.getUserId(username);
    }

    public void goToPersonalScoresActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, PersonalScoresActivity.class);
        startActivity(intent);
    }

    public void goToNewRoundActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, NewRoundActivity.class);
        startActivity(intent);
    }

    public void goToCourseLeaderboardsActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, CourseLeaderboardActivity.class);
        startActivity(intent);
    }

    public void goToUserProfileActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, UserProfileActivity.class);
        startActivity(intent);
    }
}