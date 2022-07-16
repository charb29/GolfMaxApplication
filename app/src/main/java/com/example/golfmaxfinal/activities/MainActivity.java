package com.example.golfmaxfinal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
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

import com.example.golfmaxfinal.R;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 4000;
    Animation animLogo, animSlogan;
    ImageView ivLogo;
    TextView tvSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loading_screen);

        animLogo = (Animation) AnimationUtils.loadAnimation(this, R.anim.loading_screen_logo_anim);
        animSlogan = (Animation) AnimationUtils.loadAnimation(this, R.anim.loading_screen_slogan_anim);
        ivLogo = (ImageView) findViewById(R.id.image_view_logo_icon);
        tvSlogan = (TextView) findViewById(R.id.text_view_slogan);

        ivLogo.setAnimation(animLogo);
        tvSlogan.setAnimation(animSlogan);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(ivLogo, "logo_image");
                pairs[1] = new Pair<View, String>(tvSlogan, "logo_text");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        }, SPLASH_SCREEN);
    }
}