package com.example.golfmax;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
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
import android.os.Bundle;

import com.example.golfmax.Login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;
    Animation animationLogo, animationSlogan;
    ImageView imageViewLogo;
    TextView textViewSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        animationLogo = AnimationUtils.loadAnimation(this,R.anim.top_logo_animation);
        animationSlogan = AnimationUtils.loadAnimation(this,R.anim.bottom_slogan_animation);
        imageViewLogo = findViewById(R.id.imageViewLogo);
        textViewSlogan = findViewById(R.id.textViewSlogan);
        imageViewLogo.setAnimation(animationLogo);
        textViewSlogan.setAnimation(animationSlogan);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imageViewLogo, "logo_image");
                pairs[1] = new Pair<View,  String>(textViewSlogan, "logo_text");

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        }, SPLASH_SCREEN);
    }
}