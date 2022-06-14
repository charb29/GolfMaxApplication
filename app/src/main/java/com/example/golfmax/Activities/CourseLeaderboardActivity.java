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
import android.view.WindowManager;
import android.widget.TextView;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.Models.Score;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.CourseLeaderboardRV;
import com.example.golfmax.RecyclerViews.CourseListRV;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseLeaderboardActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ActionBar actionBar;
    ColorDrawable colorDrawable;
    CourseLeaderboardRV courseLeaderboardRV;
    RecyclerView recyclerView;
    List<Score> scoreList;
    TextView textViewCourseName;
    DBHelper db;
    Course course;
    long courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_leaderboard);
        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#013220"));
        actionBar.setBackgroundDrawable(colorDrawable);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewCourseName = findViewById(R.id.textViewCourseName);
        textViewCourseName.setText(CourseListRV.courseNameForTextView);

        scoreList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCourseLeaderboard);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        db = new DBHelper(this);
        course = new Course();
        course.setId(db.getCourseId(CourseListRV.courseNameForTextView));
        courseId = course.getId();

        ApiClient.getUserService().getScoresByCourseId(courseId).enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {
                scoreList = response.body();
                Log.i("TAG ====> ", scoreList.toString());
                courseLeaderboardRV = new CourseLeaderboardRV(getApplicationContext(), scoreList);
                recyclerView.setAdapter(courseLeaderboardRV);
            }

            @Override
            public void onFailure(Call<List<Score>> call, Throwable t) {
                Log.e("FAILED ====> ", t.toString());
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