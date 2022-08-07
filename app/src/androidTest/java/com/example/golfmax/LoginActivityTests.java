package com.example.golfmax;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.golfmax.activities.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTests {

    @Rule
    public IntentsTestRule<LoginActivity> loginRule =
            new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void onClick_starts_RegistrationActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.button_create_Account)).perform(click());
        Thread.sleep(1000);
    }
}
