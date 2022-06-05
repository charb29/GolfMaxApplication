package com.example.golfmax.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
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

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    List<Scores> scoresList;
    ScoresRecyclerView scoresRecyclerView;
    RecyclerView recyclerView;
    DBHelper db;
    User user;
    ActionBar actionBar;
    ColorDrawable colorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scores);
        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#013220"));
        actionBar.setBackgroundDrawable(colorDrawable);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("My Scores");
        
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        scoresList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewScores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        db = new DBHelper(this);
        user = new User();
        user.setId(db.getUserId(LoginActivity.username));
        long userId = user.getId();

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}