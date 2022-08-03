package com.example.golfmax.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.golfmax.R;
import com.example.golfmax.backend.CourseRepository;
import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.backend.PlayerStatisticsRepository;
import com.example.golfmax.backend.ScoreRepository;
import com.example.golfmax.backend.SharedPreferencesManager;
import com.example.golfmax.contracts.ScoreContract;
import com.example.golfmax.databinding.ActivityScoreCardFront9Binding;
import com.example.golfmax.models.Course;
import com.example.golfmax.models.PlayerStatistics;
import com.example.golfmax.models.Score;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.ScorePresenter;
import com.example.golfmax.recyclerViews.NewRoundRV;

import java.util.List;

public class ScoreCardFront9Activity extends Activity implements ScoreContract.View {

    private ActivityScoreCardFront9Binding binding;
    private TextView textViewSumOfUserScores, textViewSumOfGuest1Scores,
            textViewSumOfGuest2Scores, textViewSumOfGuest3Scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        Course course = new Course();
        CourseRepository courseRepository = new CourseRepository();

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

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_score_card_front9);

        textViewSumOfUserScores = findViewById(R.id.text_view_current_score_user);
        textViewSumOfGuest1Scores = findViewById(R.id.text_view_current_score_guest1);
        textViewSumOfGuest2Scores = findViewById(R.id.text_view_current_score_guest2);
        textViewSumOfGuest3Scores = findViewById(R.id.text_view_current_score_guest3);
        Button buttonDone = findViewById(R.id.button_done);

        long courseId = getCourseIdByCourseName(NewRoundRV.staticCourseName);

        courseRepository.setScoreCardFront9Binding(binding);
        courseRepository.getCourseFront9InfoByCourseId(courseId);

        String username = SharedPreferencesManager
                .getInstance(ScoreCardFront9Activity.this)
                .getUsername();
        user.setUsername(username);

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

        buttonDone.setOnClickListener(v -> getCustomAlertDialog());
    }

    private void removeWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @NonNull
    private void getCustomAlertDialog() {
        View view = LayoutInflater
                .from(ScoreCardFront9Activity.this)
                .inflate(R.layout.custom_front9_popup_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(ScoreCardFront9Activity.this);

        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        setAlertDialogBackgroundColor(alertDialog);
        configureAlertDialogEndRoundButton(view);
        configureAlertDialogContinueButton(view);

        alertDialog.show();
    }

    private void configureAlertDialogEndRoundButton(@NonNull View view) {
        Button buttonEndRound = view.findViewById(R.id.button_end_round);
        buttonEndRound.setOnClickListener(v -> {
            ScoreRepository scoreRepository = new ScoreRepository();
            PlayerStatisticsRepository statsRepository = new PlayerStatisticsRepository();
            PlayerStatistics statistics = new PlayerStatistics();
            Score score = new Score();
            Course course = new Course();
            User user = new User();

            int userScore = getUserScore();
            double courseRating = Double.parseDouble(binding.getCourse().getCourseRating());
            double slopeRating = Double.parseDouble(binding.getCourse().getSlopeRating());
            long userId = getUserIdByUsername(binding.getUser().getUsername());
            long courseId = getCourseIdByCourseName(binding.getCourse().getCourseName());

            user.setId(userId);
            course.setCourseId(courseId);
            statistics.setUser(user);

            score.setUser(user);
            score.setCourse(course);
            score.setUserScore(userScore);
            score.setCourseRating(courseRating);
            score.setSlopeRating(slopeRating);

            Log.i("FRONT 9 SCORE ====> ", String.valueOf(score.getUserScore()));

            scoreRepository.saveScore(ScoreCardFront9Activity.this, score);
            statsRepository.updateUserStats(statistics, user.getId());

            Intent goToHomeActivity = new Intent(ScoreCardFront9Activity.this,
                    HomeActivity.class);
            startActivity(goToHomeActivity);
        });
    }

    public void configureAlertDialogContinueButton(@NonNull View view) {
        Button buttonContinue = view.findViewById(R.id.button_keep_playing);

        buttonContinue.setOnClickListener(v -> {
            Intent goToScoreCardBack9Activity = new Intent(ScoreCardFront9Activity.this,
                    ScoreCardBack9Activity.class);

            String guest1Name = binding.getGuest1().getUsername();
            String guest2Name = binding.getGuest2().getUsername();
            String guest3Name = binding.getGuest3().getUsername();
            String userScore = binding.getUserScore().getFront9Score();
            String guest1Score = binding.getGuest1Score().getFront9Score();
            String guest2Score = binding.getGuest2Score().getFront9Score();
            String guest3Score = binding.getGuest3Score().getFront9Score();

            goToScoreCardBack9Activity.putExtra("Guest 1 name", guest1Name);
            goToScoreCardBack9Activity.putExtra("Guest 2 name", guest2Name);
            goToScoreCardBack9Activity.putExtra("Guest 3 name", guest3Name);
            goToScoreCardBack9Activity.putExtra("User score", userScore);
            goToScoreCardBack9Activity.putExtra("Guest 1 score", guest1Score);
            goToScoreCardBack9Activity.putExtra("Guest 2 score", guest2Score);
            goToScoreCardBack9Activity.putExtra("Guest 3 score", guest3Score);

            startActivity(goToScoreCardBack9Activity);
        });
    }

    private int getUserScore() {
        return (Integer
                .parseInt(textViewSumOfUserScores.getText().toString()) +
                binding.getCourse().getSumOfFront9Pars()) * 2;
    }

    private void setAlertDialogBackgroundColor(@NonNull AlertDialog dialog) {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
    }

    private long getCourseIdByCourseName(String courseName) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        return db.getCourseId(courseName);
    }

    private long getUserIdByUsername(String username) {
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(this);
        return db.getUserId(username);
    }

    @Override
    public void showUserScore(@NonNull Score userScore) {
        int sumOfEnteredUserScoresPerHole = 0;
        List<String> enteredUserScores = userScore.getListOfEnteredFront9Scores();
        List<Integer> courseParsList = binding.getCourse().getFront9ParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualEnteredScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualEnteredScore == null) {
                sumOfEnteredUserScoresPerHole += 0;
            } else {
                sumOfEnteredUserScoresPerHole += Integer.parseInt(individualEnteredScore) - holePar;
            }
        }

        textViewSumOfUserScores.setText(String.valueOf(sumOfEnteredUserScoresPerHole));
        userScore.setFront9Score(textViewSumOfUserScores.getText().toString());
    }

    @Override
    public void showGuest1Score(@NonNull Score guest1Score) {
        int sumOfEnteredGuest1ScoresPerHole = 0;
        List<String> enteredUserScores = guest1Score.getListOfEnteredFront9Scores();
        List<Integer> courseParsList = binding.getCourse().getFront9ParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualEnteredScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualEnteredScore == null) {
                sumOfEnteredGuest1ScoresPerHole += 0;
            } else {
                sumOfEnteredGuest1ScoresPerHole += Integer.parseInt(individualEnteredScore) - holePar;
            }
        }

        textViewSumOfGuest1Scores.setText(String.valueOf(sumOfEnteredGuest1ScoresPerHole));
        guest1Score.setFront9Score(textViewSumOfGuest1Scores.getText().toString());
    }

    @Override
    public void showGuest2Score(@NonNull Score guest2Score) {
        int sumOfEnteredGuest2ScoresPerHole = 0;
        List<String> enteredUserScores = guest2Score.getListOfEnteredFront9Scores();
        List<Integer> courseParsList = binding.getCourse().getFront9ParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualEnteredScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualEnteredScore == null) {
                sumOfEnteredGuest2ScoresPerHole += 0;
            } else {
                sumOfEnteredGuest2ScoresPerHole += Integer.parseInt(individualEnteredScore) - holePar;
            }
        }

        textViewSumOfGuest2Scores.setText(String.valueOf(sumOfEnteredGuest2ScoresPerHole));
        guest2Score.setFront9Score(textViewSumOfGuest2Scores.getText().toString());
    }

    @Override
    public void showGuest3Score(@NonNull Score guest3Score) {
        int sumOfEnteredGuest3ScoresPerHole = 0;
        List<String> enteredUserScores = guest3Score.getListOfEnteredFront9Scores();
        List<Integer> courseParsList = binding.getCourse().getFront9ParsList();

        for (int i = 0; i < enteredUserScores.size(); i++) {
            String individualEnteredScore = enteredUserScores.get(i);
            int holePar = courseParsList.get(i);

            if (individualEnteredScore == null) {
                sumOfEnteredGuest3ScoresPerHole += 0;
            } else {
                sumOfEnteredGuest3ScoresPerHole += Integer.parseInt(individualEnteredScore) - holePar;
            }
        }

        textViewSumOfGuest3Scores.setText(String.valueOf(sumOfEnteredGuest3ScoresPerHole));
        guest3Score.setFront9Score(textViewSumOfGuest3Scores.getText().toString());
    }
}