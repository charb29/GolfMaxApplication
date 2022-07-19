package com.example.golfmaxfinal.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiClient;
import com.example.golfmaxfinal.backend.DBHelper;
import com.example.golfmaxfinal.contracts.PlayerStatisticsContract;
import com.example.golfmaxfinal.databinding.ActivityUserProfileBinding;
import com.example.golfmaxfinal.models.PlayerStatistics;
import com.example.golfmaxfinal.models.User;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileActivity extends AppCompatActivity implements PlayerStatisticsContract.View {

    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navView;
    ActionBarDrawerToggle drawerToggle;
    ColorDrawable colorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityUserProfileBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_user_profile);

        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#000f00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("User Profile");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navigation_view_user_profile);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navOpen, R.string.navClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setNavigationViewIntents(navView);

        long userId = getUserIdByUsername(LoginActivity.username);

        Log.i("USER ID > ", String.valueOf(userId));

        binding.setUser(getUserInfoById(userId));
        binding.setStats(getStatsByUserId(userId));

        Button btnUpdateUserInfo = (Button) findViewById(R.id.button_update_info);

        btnUpdateUserInfo.setOnClickListener(v -> {
            User user = new User();

            user.setUsername(binding.getUser().getUsername());
            user.setEmail(binding.getUser().getEmail());
            user.setPassword(binding.getUser().getPassword());
            user.setId(getUserIdByUsername(binding.getUser().getUsername()));

            updateUserInfo(user);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (drawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void showData(PlayerStatistics playerStatistics) {}

    public long getUserIdByUsername(String username) {
        DBHelper db = new DBHelper(this);

        return db.getUserId(username);
    }

    @NonNull
    private User getUserInfoById(long id) {
        User user = new User();
        ApiClient.getApiInterface().getUserInfoById(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,
                                   @NonNull Response<User> response) {
                assert response.body() != null;
                user.setUsername(response.body().getUsername());
                user.setEmail(response.body().getEmail());
                user.setPassword(response.body().getPassword());
                user.setId(response.body().getId());


                Log.i("USER INFO API CALL > ", user.toString());
            }

            @Override
            public void onFailure(@NonNull Call<User> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR > ", t.toString());
            }
        });
        return user;
    }

    @NonNull
    private PlayerStatistics getStatsByUserId(long id) {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        ApiClient.getApiInterface().getStatsByUserId(id)
                .enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(@NonNull Call<PlayerStatistics> call,
                                   @NonNull Response<PlayerStatistics> response) {
                assert response.body() != null;
                playerStatistics.setRoundsPlayed(response.body().getRoundsPlayed());

                Log.i("ROUNDS PLAYED > ", String.valueOf(playerStatistics.getRoundsPlayed()));
            }

            @Override
            public void onFailure(@NonNull Call<PlayerStatistics> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR > ", t.toString());
            }
        });
        return playerStatistics;
    }

    private void updateUserInfo(User user) {
        ApiClient.getApiInterface().updateUserInfo(user.getId(), user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call,
                                           @NonNull Response<User> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(UserProfileActivity.this,
                                    "User info updated successfully.",
                                    Toast.LENGTH_SHORT).show();

                            Log.i("UPDATED USER INFO > ", user.toString());
                        }
                        else {
                            Toast.makeText(UserProfileActivity.this,
                                    "Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call,
                                          @NonNull Throwable t) {
                        Log.e("ERROR > ", t.toString());
                    }
                });
    }

    private void setNavigationViewIntents(@NonNull NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navHome) {
                Intent intentHomeActivity  = new Intent(UserProfileActivity.this,
                        HomeActivity.class);
                startActivity(intentHomeActivity);
                return true;
            }
            if (item.getItemId() == R.id.navLeaderboard) {
                Intent intentLeaderboardActivity = new Intent(UserProfileActivity.this,
                        CourseLeaderboardActivity.class);
                startActivity(intentLeaderboardActivity);
                return true;
            }
            if (item.getItemId() == R.id.navMyScores) {
                Intent intentPersonalScoresActivity = new Intent(UserProfileActivity.this,
                        PersonalScoresActivity.class);
                startActivity(intentPersonalScoresActivity);
                return true;
            }
            if (item.getItemId() == R.id.navPlayRound) {
                Intent intentNewRoundActivity = new Intent(UserProfileActivity.this,
                        NewRoundActivity.class);
                startActivity(intentNewRoundActivity);
                return true;
            }
            else {
                return false;
            }
        });
    }
}