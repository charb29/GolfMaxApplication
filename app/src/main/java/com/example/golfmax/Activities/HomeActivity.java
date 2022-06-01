package com.example.golfmax.Activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.PopUpDialog;
import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.R;

public class HomeActivity extends AppCompatActivity {

    Button buttonViewScores, buttonAddScores, buttonPlay, buttonLeaderBoards, buttonSettings;
    LoginResponse loginResponse;
    DBHelper db = new DBHelper(HomeActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        buttonViewScores = findViewById(R.id.buttonViewScores);
        buttonAddScores = findViewById(R.id.buttonAddScores);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonLeaderBoards = findViewById(R.id.buttonLeaderboards);
        buttonSettings = findViewById(R.id.buttonSettings);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.i("LoginActivity", "====> " + loginResponse.getEmail());
            Log.i("LoginActivity", "====> " + loginResponse.getId());
        }

        buttonAddScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        buttonViewScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ViewScoresActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openDialog() {
        PopUpDialog popUp = new PopUpDialog();
        popUp.show(getSupportFragmentManager(), "pop-up dialog");
    }
}
