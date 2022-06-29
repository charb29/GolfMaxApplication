package com.example.golfmax.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.PlayerStatistics;
import com.example.golfmax.Models.User;
import com.example.golfmax.R;
import com.example.golfmax.Requests.UserRequest;
import com.example.golfmax.Responses.UserResponse;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileActivity extends AppCompatActivity {

    ActionBar actionBar;
    ColorDrawable colorDrawable;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView tvUsername, tvRoundsPlayed;
    TextInputEditText tiUsername, tiEmail, tiPassword;
    Button btnUpdateInfo;
    long userId;
    User user;
    DBHelper db;
    PlayerStatistics statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navHome:
                        Intent intentHome = new Intent(UserProfileActivity.this, HomeActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.navLeaderboard:
                        Intent intentLeaderboards = new Intent(UserProfileActivity.this, CourseListActivity.class);
                        startActivity(intentLeaderboards);
                        return true;

                    case R.id.navMyScores:
                        Intent intentMyScores = new Intent(UserProfileActivity.this, MyScoresActivity.class);
                        startActivity(intentMyScores);
                        return true;

                    case R.id.navPlayRound:
                        Intent intentPlayRound = new Intent(UserProfileActivity.this, PlayRoundActivity.class);
                        startActivity(intentPlayRound);
                        return true;
                }
                return false;
            }
        });

        tvUsername = findViewById(R.id.text_view_username);
        tvRoundsPlayed = findViewById(R.id.text_view_rounds_played);

        tiUsername = findViewById(R.id.text_input_username);
        tiEmail = findViewById(R.id.text_input_email);
        tiPassword = findViewById(R.id.text_input_password);

        btnUpdateInfo = findViewById(R.id.button_update_info);

        db = new DBHelper(this);
        user = new User();
        statistics = new PlayerStatistics();

        user.setId(db.getUserId(LoginActivity.username));
        userId = user.getId();

        ApiClient.getUserService().getUserInfoById(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                tvUsername.setText(user.getUsername());
                tiUsername.setText(user.getUsername());
                tiEmail.setText(user.getEmail());
                tiPassword.setText(user.getPassword());
                Log.i("USER INFO ====> ", response.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });

        ApiClient.getUserService().getStatsByUserId(userId).enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(Call<PlayerStatistics> call, Response<PlayerStatistics> response) {
                statistics = response.body();
                tvRoundsPlayed.setText(String.valueOf(statistics.getRoundsPlayed()));
                Log.i("INFO ====> ", response.toString());
            }

            @Override
            public void onFailure(Call<PlayerStatistics> call, Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });

        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setUsername(tiUsername.getText().toString());
                user.setPassword(tiPassword.getText().toString());
                user.setEmail(tiEmail.getText().toString());

                user.getUsername();
                user.getPassword();
                user.getEmail();
                updateUserInfo(user);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void updateUserInfo(User user) {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().updateUserInfo(user.getId(), user);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(UserProfileActivity.this, "User info update successful.", Toast.LENGTH_SHORT).show();
                    Log.i("USER INFO ====> ", response.toString());
                }
                else {
                    Toast.makeText(UserProfileActivity.this,"Failed.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("FAILURE ====> ", t.toString());
            }
        });
    }
}