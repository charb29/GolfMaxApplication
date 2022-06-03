package com.example.golfmax.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Courses;
import com.example.golfmax.Models.Scores;
import com.example.golfmax.Models.User;
import com.example.golfmax.R;
import com.example.golfmax.ScoresRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewScoresActivity extends AppCompatActivity {


    List<Scores> scoresList;
    ScoresRecyclerView scoresRecyclerView;
    RecyclerView recyclerView;
    ImageButton imageButtonHome;
    DBHelper db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_view_scores);

        imageButtonHome = findViewById(R.id.imageButtonHome);
        scoresList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewScores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        db = new DBHelper(this);
        user = new User();
        user.setId(db.getUserId(LoginActivity.username));
        long userId = user.getId();

        imageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScoresActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        ApiClient.getUserService().getScores(userId).enqueue(new Callback<List<Scores>>() {
            @Override
            public void onResponse(Call<List<Scores>> call, Response<List<Scores>> response) {
                scoresList = response.body();
                Log.i("TAG ====> ", scoresList.toString());
                scoresRecyclerView = new ScoresRecyclerView(getApplicationContext(), scoresList);
                recyclerView.setAdapter(scoresRecyclerView);
            }

            @Override
            public void onFailure(Call<List<Scores>> call, Throwable t) {
                Log.i("FAILED ===>", t.toString());
            }
        });
    }
}