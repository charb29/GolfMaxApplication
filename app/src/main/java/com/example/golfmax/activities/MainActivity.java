package com.example.golfmax.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.golfmax.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 4000;
    private Animation animLogo, animSlogan;
    private ImageView imageViewLogo;
    private TextView textViewSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow()
                .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        hideActionBar();
        setContentView(R.layout.activity_loading_screen);

        animLogo = AnimationUtils.loadAnimation(this, R.anim.loading_screen_logo_anim);
        animSlogan = AnimationUtils.loadAnimation(this, R.anim.loading_screen_slogan_anim);
        imageViewLogo = findViewById(R.id.image_view_logo_icon);
        textViewSlogan = findViewById(R.id.text_view_slogan);

        imageViewLogo.setAnimation(animLogo);
        textViewSlogan.setAnimation(animSlogan);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(imageViewLogo, "logo_image");
            pairs[1] = new Pair<View, String>(textViewSlogan, "logo_text");

            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, activityOptions.toBundle());

        }, SPLASH_SCREEN);
    }

    private void hideActionBar() {
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}