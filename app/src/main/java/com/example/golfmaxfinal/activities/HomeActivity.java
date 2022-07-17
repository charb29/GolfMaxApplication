package com.example.golfmaxfinal.activities;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiClient;
import com.example.golfmaxfinal.backend.DBHelper;
import com.example.golfmaxfinal.contracts.PlayerStatisticsContract;
import com.example.golfmaxfinal.databinding.ActivityHomeBinding;
import com.example.golfmaxfinal.models.PlayerStatistics;
import com.example.golfmaxfinal.models.User;
import com.example.golfmaxfinal.presenters.PlayerStatisticsPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity implements PlayerStatisticsContract.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        long userId = getUserIdByUsername(LoginActivity.username);

        binding.setStats(getPlayerStatsByUserId(userId));
    }

    @Override
    public void showData(PlayerStatistics playerStatistics) {}

    public long getUserIdByUsername(String username) {
        DBHelper db = new DBHelper(this);
        User user = new User();
        user.setId(db.getUserId(username));
        long userId = user.getId();

        return userId;
    }

    @NonNull
    private PlayerStatistics getPlayerStatsByUserId(long userId) {
        Call<PlayerStatistics> playerStatisticsCall = ApiClient.getApiInterface().getStatsByUserId(userId);
        PlayerStatistics playerStatistics = new PlayerStatistics();

        playerStatisticsCall.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(Call<PlayerStatistics> call, Response<PlayerStatistics> response) {
                playerStatistics.setAverageScore(response.body().getAverageScore());
                playerStatistics.setHandicapIndex(response.body().getHandicapIndex());

                Log.i("PLAYER STATS API CALL >", playerStatistics.toString());
            }

            @Override
            public void onFailure(Call<PlayerStatistics> call, Throwable t) {
                Log.e("ERROR > ", t.toString());
            }
        });

        return playerStatistics;
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