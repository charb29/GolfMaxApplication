package com.example.golfmax;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    Button addScoresButton, viewScoresButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        addScoresButton = findViewById(R.id.btnAddScores);
        viewScoresButton = findViewById(R.id.btnViewScores);

        addScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        viewScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ViewScoresActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openDialog() {
        PopUpDialogActivity popUpDialog = new PopUpDialogActivity();
        popUpDialog.show(getSupportFragmentManager(), "pop-up dialog");
    }
}
