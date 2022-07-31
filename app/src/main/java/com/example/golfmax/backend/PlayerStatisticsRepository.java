package com.example.golfmax.backend;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.golfmax.models.PlayerStatistics;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerStatisticsRepository {

    public PlayerStatistics displayStatsSummary(long userId) {
        Call<PlayerStatistics> call = GolfMaxHttpClient
                .getApiInterface()
                .getStatsByUserId(userId);

        PlayerStatistics playerStatistics = new PlayerStatistics();

        call.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(@NonNull Call<PlayerStatistics> call,
                                   @NonNull Response<PlayerStatistics> response) {
                assert response.body() != null;
                playerStatistics.setHandicapIndex(response.body().getHandicapIndex());
                playerStatistics.setAverageScore(response.body().getAverageScore());

                Log.i("HANDICAP INDEX ====> ", playerStatistics
                        .toStringHandicapIndex());
                Log.i("AVERAGE SCORE ====> ", playerStatistics
                        .toStringAverageScore());
            }

            @Override
            public void onFailure(@NonNull Call<PlayerStatistics> call,
                                  @NonNull Throwable t) {
                Log.i("ERROR ====> ", t.toString());
            }
        });
        return playerStatistics;
    }


    public PlayerStatistics displayRoundsPlayed(long userId) {
        Call<PlayerStatistics> call = GolfMaxHttpClient
                .getApiInterface()
                .getStatsByUserId(userId);

        PlayerStatistics PlayerStatistics = new PlayerStatistics();

        call.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(@NonNull Call<PlayerStatistics> call,
                                   @NonNull Response<PlayerStatistics> response) {
                assert response.body() != null;
                PlayerStatistics.setRoundsPlayed(response.body().getRoundsPlayed());

                Log.i("ROUNDS PLAYED ====> ", PlayerStatistics
                        .toStringRoundsPlayed());
            }

            @Override
            public void onFailure(@NonNull Call<PlayerStatistics> call,
                                  @NonNull Throwable t) {
                Log.i("ERROR ====> ", t.toString());
            }
        });
        return PlayerStatistics;
    }
}
