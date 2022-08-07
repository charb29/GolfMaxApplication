package com.example.golfmax;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.golfmax.activities.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTests {

    @Rule
    public IntentsTestRule<HomeActivity> homeRule =
            new IntentsTestRule<>(HomeActivity.class);

    @Test
    public void onClick_starts_PersonalScoresActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.card_view_my_scores)).perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void onClick_starts_NewRoundActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.card_view_play_round)).perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void onClick_starts_LeaderboardsActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.card_view_leaderboards)).perform(click());
        Thread.sleep(1000);
    }

    @Test
    public void onClick_starts_UserProfileActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.card_view_user_profile)).perform(click());
        Thread.sleep(1000);
    }
}
