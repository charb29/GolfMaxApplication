package com.example.golfmax.models;

import android.content.Context;

import com.example.golfmax.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewIntents {

    private final Context context;
    private final NavigationView navigationView;
    private final GolfMaxIntents golfMaxIntents;

    public NavigationViewIntents(Context context,
                                 NavigationView navigationView,
                                 GolfMaxIntents golfMaxIntents) {
        this.context = context;
        this.navigationView = navigationView;
        this.golfMaxIntents = golfMaxIntents;
    }

    public void setNavigationViewIntents() {
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navHome)
                golfMaxIntents.goToHomeActivity();
            if (item.getItemId() == R.id.navLeaderboard)
                golfMaxIntents.goToCourseLeaderBoardActivity();
            if (item.getItemId() == R.id.navMyScores)
                golfMaxIntents.goToPersonalScoresActivity();
            if (item.getItemId() == R.id.navPlayRound)
                golfMaxIntents.goToPlayRoundActivity();
            if (item.getItemId() == R.id.navUserProfile)
                golfMaxIntents.goToUserProfileActivity();
            return false;
        });
    }
}
