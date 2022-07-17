package com.example.golfmaxfinal.activities;

import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiClient;
import com.example.golfmaxfinal.backend.DBHelper;
import com.example.golfmaxfinal.contracts.PlayerStatisticsContract;
import com.example.golfmaxfinal.databinding.ActivityHomeBinding;
import com.example.golfmaxfinal.models.PlayerStatistics;
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
        PlayerStatisticsPresenter presenter = new PlayerStatisticsPresenter(this, getApplicationContext());
        PlayerStatistics playerStatistics = new PlayerStatistics();
    }

    @Override
    public void showData(PlayerStatistics playerStatistics) {}

    private long getUserIdByUsername(String username) {
        DBHelper db = new DBHelper(this);
        long userId = db.getUserId(username);

        return userId;
    }

    private void getPlayerStatsByUserId(long userId) {
        ApiClient.getApiInterface().getStatsByUserId(userId).enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(Call<PlayerStatistics> call, Response<PlayerStatistics> response) {
                PlayerStatistics statistics = response.body();
                statistics.setHandicapIndex(statistics.getHandicapIndex());
                statistics.setAverageScore(statistics.getAverageScore());
                Log.i("PLAYER STATS > ",  statistics.toString());
            }

            @Override
            public void onFailure(Call<PlayerStatistics> call, Throwable t) {
                Log.e("PLAYERS STATS ERROR > ", t.toString());
            }
        });
    }
}