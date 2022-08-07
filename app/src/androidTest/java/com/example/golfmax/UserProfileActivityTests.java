package com.example.golfmax;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.golfmax.activities.UserProfileActivity;

@RunWith(AndroidJUnit4.class)
public class UserProfileActivityTests {

    @Rule
    public IntentsTestRule<UserProfileActivity> userProfileRule =
            new IntentsTestRule<>(UserProfileActivity.class);

    @Test
    public void navigationView_test_goToHomeActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_view_user_profile))
                .perform(NavigationViewActions.navigateTo(R.id.navHome));
        Thread.sleep(1000);
    }

    @Test
    public void navigationView_test_goToLeaderboardActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_view_user_profile))
                .perform(NavigationViewActions.navigateTo(R.id.navLeaderboard));
        Thread.sleep(1000);
    }

    @Test
    public void navigationView_test_goToPersonalScoresActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_view_user_profile))
                .perform(NavigationViewActions.navigateTo(R.id.navMyScores));
        Thread.sleep(1000);
    }

    @Test
    public void navigationView_test_goToNewRoundActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_view_user_profile))
                .perform(NavigationViewActions.navigateTo(R.id.navPlayRound));
        Thread.sleep(1000);
    }
}
