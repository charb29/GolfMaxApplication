package com.example.golfmax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewScoresActivity extends AppCompatActivity {

    List<Scores> scoresList;
    ScoresRecyclerView scoresRecyclerView;
    RecyclerView recyclerView;
    User user;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_view_scores);

        scoresList = new ArrayList<>();
        user = new User();
        db = new DBHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.idRVScores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        user.setId(db.getUserId(LoginActivity.username));
        long userId = user.getId();

        Call<List<Scores>> scoresCall = ApiClient.getUserService().getScores(userId);
        scoresCall.enqueue(new Callback<List<Scores>>() {
            @Override
            public void onResponse(Call<List<Scores>> call, Response<List<Scores>> response) {
                scoresList = response.body();

                Log.i("TAG ====> ", scoresList.toString());
                scoresRecyclerView = new ScoresRecyclerView(getApplicationContext(), scoresList);
                recyclerView.setAdapter(scoresRecyclerView);
            }

            @Override
            public void onFailure(Call<List<Scores>> call, Throwable t) {
                Log.e("ViewScoresActivity", t.toString());
            }
        });
    }
}