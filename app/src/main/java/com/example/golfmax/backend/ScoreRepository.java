package com.example.golfmax.backend;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.golfmax.databinding.ActivityCourseLeaderboardBinding;
import com.example.golfmax.databinding.ActivityPersonalScoresBinding;
import com.example.golfmax.models.Score;
import com.example.golfmax.recyclerViews.CourseLeaderBoardRV;
import com.example.golfmax.recyclerViews.PersonalScoresRV;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreRepository {

    private ActivityCourseLeaderboardBinding courseLeaderboardBinding;
    private ActivityPersonalScoresBinding personalScoresBinding;
    private List<Score> scoreList;

    public ActivityCourseLeaderboardBinding getCourseLeaderboardBinding() {
        return courseLeaderboardBinding;
    }

    public void setCourseLeaderboardBinding(ActivityCourseLeaderboardBinding binding) {
        this.courseLeaderboardBinding = binding;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public ActivityPersonalScoresBinding getPersonalScoresBinding() {
        return personalScoresBinding;
    }

    public void setPersonalScoresBinding(ActivityPersonalScoresBinding personalScoresBinding) {
        this.personalScoresBinding = personalScoresBinding;
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
                courseLeaderboardBinding.viewScores.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                courseLeaderboardBinding.viewScores.setAdapter(
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

    public void getScoresByUserId(Context context, long userId) {

        Call<List<Score>> scoreCall = GolfMaxHttpClient
                .getApiInterface()
                .getScoresByUserId(userId);

        scoreCall.enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(@NonNull Call<List<Score>> call,
                                   @NonNull Response<List<Score>> response) {
                setScoreList(response.body());
                personalScoresBinding.recyclerViewPersonalScores.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                personalScoresBinding.recyclerViewPersonalScores.setAdapter(
                        new PersonalScoresRV(context.getApplicationContext(), scoreList));

                Log.i("getScoresByUserId ===> ", scoreList.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Score>> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }
}
