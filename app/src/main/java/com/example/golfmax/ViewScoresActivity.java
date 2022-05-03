package com.example.golfmax;

import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewScoresActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ScoresRecyclerView scoresRV;
    private DBHelper db;
    private ArrayList<UserScores> userScoresArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_view_scores);


        userScoresArrayList = new ArrayList<>();
        db = new DBHelper(ViewScoresActivity.this);
        userScoresArrayList = db.readScores();
        scoresRV = new ScoresRecyclerView(userScoresArrayList, ViewScoresActivity.this);
        rv = findViewById(R.id.RvScores);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewScoresActivity.this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(scoresRV);
    }
}