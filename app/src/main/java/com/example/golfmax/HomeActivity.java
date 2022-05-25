package com.example.golfmax;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    Button buttonAddScores, buttonViewScores;
    ScoreRequest scoreRequest = new ScoreRequest();
    LoginResponse loginResponse;
    DBHelper db = new DBHelper(HomeActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        buttonAddScores = findViewById(R.id.btnAddScores);
        buttonViewScores = findViewById(R.id.btnViewScores);

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
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.e("TAG", "====> " + loginResponse.getEmail());
            Log.e("TAG", "====>" + loginResponse.getId());
            db.saveUser(loginResponse.getUsername(), loginResponse.getId());
        }
        popUp.show(getSupportFragmentManager(), "pop-up dialog");
    }
}
