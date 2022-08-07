package com.example.golfmax.models;

import android.content.Context;
import android.content.Intent;

import com.example.golfmax.activities.CourseLeaderboardActivity;
import com.example.golfmax.activities.HomeActivity;
import com.example.golfmax.activities.LoginActivity;
import com.example.golfmax.activities.NewRoundActivity;
import com.example.golfmax.activities.PersonalScoresActivity;
import com.example.golfmax.activities.RegistrationActivity;
import com.example.golfmax.activities.UserProfileActivity;

public class GolfMaxIntents {

    private final Context context;

    public GolfMaxIntents(Context context) {
        this.context = context;
    }

    public void goToHomeActivity() {
        Intent goToHomeActivity = new Intent(
                context.getApplicationContext(),
                HomeActivity.class);
        context.startActivity(goToHomeActivity);
    }

    public void goToPersonalScoresActivity() {
        Intent goToPersonalScoresActivity = new Intent(
                context.getApplicationContext(),
                PersonalScoresActivity.class);
        context.startActivity(goToPersonalScoresActivity);
    }

    public void goToCourseLeaderBoardActivity() {
        Intent goToCourseLeaderBoardActivity = new Intent(
                context.getApplicationContext(),
                CourseLeaderboardActivity.class);
        context.startActivity(goToCourseLeaderBoardActivity);
    }

    public void goToPlayRoundActivity() {
        Intent goToNewRoundActivity = new Intent(
                context.getApplicationContext(),
                NewRoundActivity.class);
        context.startActivity(goToNewRoundActivity);
    }

    public void goToUserProfileActivity() {
        Intent goToUserProfileActivity = new Intent(
                context.getApplicationContext(),
                UserProfileActivity.class);
        context.startActivity(goToUserProfileActivity);
    }

    public void goToRegistrationActivity() {
        Intent goToRegistrationActivity = new Intent(
                context.getApplicationContext(),
                RegistrationActivity.class);
        context.startActivity(goToRegistrationActivity);
    }

    public void goToLoginActivity() {
        Intent goToLoginActivity = new Intent(
                context.getApplicationContext(),
                LoginActivity.class);
        context.startActivity(goToLoginActivity);
    }
}
