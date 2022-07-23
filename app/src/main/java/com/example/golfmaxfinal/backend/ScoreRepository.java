package com.example.golfmaxfinal.backend;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.golfmaxfinal.databinding.ActivityCourseLeaderboardBinding;
import com.example.golfmaxfinal.models.Score;
import com.example.golfmaxfinal.recyclerViews.CourseLeaderBoardRV;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreRepository {

    private ActivityCourseLeaderboardBinding binding;
    private List<Score> scoreList;

    public ActivityCourseLeaderboardBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityCourseLeaderboardBinding binding) {
        this.binding = binding;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public void getScoresByCourseId(Context context, long courseId) {

        Call<List<Score>> scoreCall = GolfMaxHttpClient
                .getApiInterface()
                .getScoresByCourseId(courseId);

        scoreCall.enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(@NonNull Call<List<Score>> call,
                                   @NonNull Response<List<Score>> response) {
                setScoreList(response.body());
                binding.viewScores.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                binding.viewScores.setAdapter(
                        new CourseLeaderBoardRV(context.getApplicationContext(), scoreList));

                Log.i("getScoresByCourseId => ", scoreList.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Score>> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }
}
