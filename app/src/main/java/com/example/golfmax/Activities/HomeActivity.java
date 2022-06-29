package com.example.golfmax.Activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.R;

public class HomeActivity extends AppCompatActivity {

    CardView cvMyScores, cvPlayRound, cvLeaderboard, cvUserProfile;
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        cvMyScores = findViewById(R.id.card_view_my_scores);
        cvPlayRound = findViewById(R.id.card_view_play_round);
        cvLeaderboard = findViewById(R.id.card_view_leaderboards);
        cvUserProfile = findViewById(R.id.card_view_user_profile);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.i("LoginActivity", "====> " + loginResponse.getEmail());
            Log.i("LoginActivity", "====> " + loginResponse.getId());
        }

        cvMyScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyScoresActivity.class);
                startActivity(intent);
            }
        });

        cvLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });

        cvUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

        cvPlayRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PlayRoundActivity.class);
                startActivity(intent);
            }
        });
    }
}
