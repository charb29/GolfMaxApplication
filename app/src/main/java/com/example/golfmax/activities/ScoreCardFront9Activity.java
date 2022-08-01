package com.example.golfmax.activities;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.golfmax.backend.CourseRepository;
import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.ScoreRepository;
import com.example.golfmax.contracts.ScoreContract;
import com.example.golfmax.models.Course;
import com.example.golfmax.models.Score;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.ScorePresenter;
import com.example.golfmax.recyclerViews.NewRoundRV;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityScoreCardFront9Binding;

import java.util.List;
import java.util.Objects;


public class ScoreCardFront9Activity extends Activity implements ScoreContract.View {

    private ActivityScoreCardFront9Binding binding;
    private  TextView textViewSumOfUserScores, textViewSumOfGuest1Scores,
            textViewSumOfGuest2Scores, textViewSumOfGuest3Scores;
    public static String staticUserFront9Score;
    public static String staticGuest1Front9Score;
    public static String staticGuest2Front9Score;
    public static String staticGuest3Front9Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_score_card_front9);

        textViewSumOfUserScores = findViewById(R.id.text_view_current_score_user);
        textViewSumOfGuest1Scores = findViewById(R.id.text_view_current_score_guest1);
        textViewSumOfGuest2Scores = findViewById(R.id.text_view_current_score_guest2);
        textViewSumOfGuest3Scores = findViewById(R.id.text_view_current_score_guest3);

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.setScoreCardFront9Binding(binding);

        Course course = new Course();
        ScorePresenter userScorePresenter = new ScorePresenter(this, getApplicationContext());
        ScorePresenter guest1ScorePresenter = new ScorePresenter(this, getApplicationContext());
        ScorePresenter guest2ScorePresenter = new ScorePresenter(this, getApplicationContext());
        ScorePresenter guest3ScorePresenter = new ScorePresenter(this, getApplicationContext());

        User user = new User();
        User guest1 = new User();
        User guest2 = new User();
        User guest3 = new User();

        Score userScore = new Score();
        Score guest1Score = new Score();
        Score guest2Score = new Score();
        Score guest3Score = new Score();

        long courseId = getCourseIdByCourseName(NewRoundRV.staticCourseName);
        courseRepository.getCourseInfoById(courseId);
        user.setUsername(LoginActivity.staticLoginActivityUsername);

        binding.setUser(user);
        binding.setGuest1(guest1);
        binding.setGuest2(guest2);
        binding.setGuest3(guest3);

        binding.setUserScore(userScore);
        binding.setGuest1Score(guest1Score);
        binding.setGuest2Score(guest2Score);
        binding.setGuest3Score(guest3Score);

        binding.setScorePresenter(userScorePresenter);
        binding.setScorePresenter(guest1ScorePresenter);
        binding.setScorePresenter(guest2ScorePresenter);
        binding.setScorePresenter(guest3ScorePresenter);

        binding.setCourse(course);
    }

    @NonNull
    private AlertDialog getCustomAlertDialog() {
        View view = LayoutInflater.from(
                ScoreCardFront9Activity.this)
                .inflate(R.layout.custom_front9_popup_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(ScoreCardFront9Activity.this);

        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        removeAlertDialogBackgroundColor(alertDialog);
        configureAlertDialogCancelButton(view);
        configureAlertDialogContinueButton(view);

        alertDialog.show();

        return alertDialog;
    }

    public void configureAlertDialogContinueButton(@NonNull View view) {
        Button buttonContinue = view.findViewById(R.id.button_keep_playing);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreCardFront9Activity.this,
                        ScoreCardBack9Activity.class);

                startActivity(intent);
            }
        });
    }

    private void configureAlertDialogCancelButton(@NonNull View view) {
        ScoreRepository scoreRepository = new ScoreRepository();
        Button buttonCancel = view.findViewById(R.id.button_end_round);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userScore = (Integer.parseInt(binding
                        .textViewCurrentScoreUser
                                .getText()
                                .toString())) * 2;

                Score score = new Score();

                score.setUserScore(String.valueOf(userScore));
                score.setCourse(binding.getCourse());
                score.setCourseRating(Integer.parseInt(score.getCourse().getCourseRating()));
                score.setSlopeRating(Integer.parseInt(score.getCourse().getSlopeRating()));

                scoreRepository.saveScore(ScoreCardFront9Activity.this, score);
            }
        });
    }

    private void removeAlertDialogBackgroundColor(@NonNull AlertDialog dialog) {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private long getCourseIdByCourseName(String courseName) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        return db.getCourseId(courseName);
    }

    @Override
    public void showUserScore(@NonNull Score userScore) {
        int scoreSummary = 0;
        List<String> enteredUserScores = userScore.getListOfEnteredScores();
        List<Integer> courseParsList = binding.getCourse().getCourseParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualScore == null) {
                scoreSummary += 0;
            } else {
                scoreSummary += Integer.parseInt(individualScore) - holePar;
            }
        }

        textViewSumOfUserScores.setText(String.valueOf(scoreSummary));
        userScore.setFront9Score(textViewSumOfUserScores.getText().toString());
        staticUserFront9Score = userScore.getFront9Score();
    }

    @Override
    public void showGuest1Score(@NonNull Score guest1Score) {
        int scoreSummary = 0;
        List<String> enteredUserScores = guest1Score.getListOfEnteredScores();
        List<Integer> courseParsList = binding.getCourse().getCourseParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualScore == null) {
                scoreSummary += 0;
            } else {
                scoreSummary += Integer.parseInt(individualScore) - holePar;
            }
        }

        textViewSumOfGuest1Scores.setText(String.valueOf(scoreSummary));
        guest1Score.setFront9Score(textViewSumOfGuest1Scores.getText().toString());
        staticGuest1Front9Score = guest1Score.getFront9Score();
    }

    @Override
    public void showGuest2Score(@NonNull Score guest2Score) {
        int scoreSummary = 0;
        List<String> enteredUserScores = guest2Score.getListOfEnteredScores();
        List<Integer> courseParsList = binding.getCourse().getCourseParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualScore == null) {
                scoreSummary += 0;
            } else {
                scoreSummary += Integer.parseInt(individualScore) - holePar;
            }
        }

        textViewSumOfGuest2Scores.setText(String.valueOf(scoreSummary));
        guest2Score.setFront9Score(textViewSumOfGuest2Scores.getText().toString());
        staticGuest2Front9Score = guest2Score.getFront9Score();
    }

    @Override
    public void showGuest3Score(@NonNull Score guest3Score) {
        int scoreSummary = 0;
        List<String> enteredUserScores = guest3Score.getListOfEnteredScores();
        List<Integer> courseParsList = binding.getCourse().getCourseParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualScore == null) {
                scoreSummary += 0;
            } else {
                scoreSummary += Integer.parseInt(individualScore) - holePar;
            }
        }

        textViewSumOfGuest3Scores.setText(String.valueOf(scoreSummary));
        guest3Score.setFront9Score(textViewSumOfGuest3Scores.getText().toString());
        staticGuest3Front9Score = guest3Score.getFront9Score();
    }
}