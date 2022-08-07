package com.example.golfmax;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.golfmax.activities.RegistrationActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegistrationActivityTests {

    @Rule
    public IntentsTestRule<RegistrationActivity> registrationRule =
            new IntentsTestRule<>(RegistrationActivity.class);

    @Test
    public void onClick_starts_LoginActivity() throws InterruptedException {
        Thread.sleep(2000);
        onView(withId(R.id.button_login)).perform(click());
        Thread.sleep(1000);
    }
}
