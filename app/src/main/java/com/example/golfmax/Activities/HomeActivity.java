package com.example.golfmax.Activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.PlayerStatistics;
import com.example.golfmax.Models.User;
import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.R;
import com.example.golfmax.Responses.PlayerStatisticsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    CardView cvMyScores, cvPlayRound, cvLeaderboard, cvUserProfile;
    TextView tvHandicapIndex, tvAverageScore;
    LoginResponse loginResponse;
    PlayerStatistics statistics;
    DBHelper db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.i("LoginActivity", "====> " + loginResponse.getEmail());
            Log.i("LoginActivity", "====> " + loginResponse.getId());
        }

        cvMyScores = findViewById(R.id.card_view_my_scores);
        cvPlayRound = findViewById(R.id.card_view_play_round);
        cvLeaderboard = findViewById(R.id.card_view_leaderboards);
        cvUserProfile = findViewById(R.id.card_view_user_profile);

        tvHandicapIndex = findViewById(R.id.text_view_handicap_index);
        tvAverageScore = findViewById(R.id.text_view_average_score);
        long userId = getUserIdByUsername(LoginActivity.username);

        getUserStatsByUserId(userId);
        startNewActivity(cvMyScores, cvLeaderboard, cvUserProfile, cvPlayRound);
    }

    private long getUserIdByUsername(String username) {
        db = new DBHelper(this);
        user = new User();
        user.setId(db.getUserId(username));
        long userId = user.getId();

        return userId;
    }

    private void getUserStatsByUserId(long userId) {
        statistics = new PlayerStatistics();

        Call<PlayerStatistics> playerStatisticsCall = ApiClient.getUserService().getStatsByUserId(userId);
        playerStatisticsCall.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(Call<PlayerStatistics> call, Response<PlayerStatistics> response) {
                statistics = response.body();
                tvAverageScore.setText(String.valueOf(statistics.getAverageScore()));
                tvHandicapIndex.setText(String.valueOf(statistics.getHandicapIndex()));
                Log.i("INFO ====> ", response.toString());
            }

            @Override
            public void onFailure(Call<PlayerStatistics> call, Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }

    private void startNewActivity(CardView myScores, CardView leaderBoard, CardView userProfile, CardView playRound) {
        myScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyScoresActivity.class);
                startActivity(intent);
            }
        });

        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });

        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

        playRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PlayRoundActivity.class);
                startActivity(intent);
            }
        });
    }
}
