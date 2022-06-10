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

    CardView cardViewMyScores, cardViewPlayRound, cardViewLeaderboard, cardViewSettings;
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        cardViewMyScores = findViewById(R.id.cardViewMyScores);
        cardViewPlayRound = findViewById(R.id.cardViewPlayRound);
        cardViewLeaderboard = findViewById(R.id.cardViewLeaderboard);
        cardViewSettings = findViewById(R.id.cardViewSettings);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.i("LoginActivity", "====> " + loginResponse.getEmail());
            Log.i("LoginActivity", "====> " + loginResponse.getId());
        }

        cardViewMyScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ViewScoresActivity.class);
                startActivity(intent);
            }
        });

        cardViewLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LeaderboardsActivity.class);
                startActivity(intent);
            }
        });
    }
}
