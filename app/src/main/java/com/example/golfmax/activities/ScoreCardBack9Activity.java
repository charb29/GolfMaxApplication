package com.example.golfmax.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
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
import com.example.golfmax.databinding.ActivityScoreCardBack9Binding;
import com.example.golfmax.models.Course;
import com.example.golfmax.models.PlayerStatistics;
import com.example.golfmax.models.Score;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.ScorePresenter;
import com.example.golfmax.recyclerViews.NewRoundRV;

import java.util.List;

public class ScoreCardBack9Activity extends Activity implements ScoreContract.View {

    private ActivityScoreCardBack9Binding binding;
    private TextView textViewSumOfUserScores, textViewSumOfGuest1Scores,
            textViewSumOfGuest2Scores, textViewSumOfGuest3Scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        Intent getScoreCardFront9Data = getIntent();
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
                .setContentView(this, R.layout.activity_score_card_back9);

        textViewSumOfUserScores = findViewById(R.id.text_view_current_score_user);
        textViewSumOfGuest1Scores = findViewById(R.id.text_view_current_score_guest1);
        textViewSumOfGuest2Scores = findViewById(R.id.text_view_current_score_guest2);
        textViewSumOfGuest3Scores = findViewById(R.id.text_view_current_score_guest3);

        Button buttonDone = findViewById(R.id.button_done);

        long courseId = getCourseIdByCourseName(NewRoundRV.staticCourseName);

        courseRepository.setScoreCardBack9Binding(binding);
        courseRepository.getCourseBack9InfoByCourseId(courseId);

        String username = SharedPreferencesManager
                .getInstance(ScoreCardBack9Activity.this)
                .getUsername();
        String guest1Name = getScoreCardFront9Data.getStringExtra("Guest 1 name");
        String guest2Name = getScoreCardFront9Data.getStringExtra("Guest 2 name");
        String guest3Name = getScoreCardFront9Data.getStringExtra("Guest 3 name");

        user.setUsername(username);
        guest1.setUsername(guest1Name);
        guest2.setUsername(guest2Name);
        guest3.setUsername(guest3Name);

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

        String userFront9Score = getScoreCardFront9Data.getStringExtra("User score");
        String guest1Front9Score = getScoreCardFront9Data.getStringExtra("Guest 1 score");
        String guest2Front9Score = getScoreCardFront9Data.getStringExtra("Guest 2 score");
        String guest3Front9Score = getScoreCardFront9Data.getStringExtra("Guest 3 score");

        binding.textViewCurrentScoreUser.setText(userFront9Score);
        binding.textViewCurrentScoreGuest1.setText(guest1Front9Score);
        binding.textViewCurrentScoreGuest2.setText(guest2Front9Score);
        binding.textViewCurrentScoreGuest3.setText(guest3Front9Score);

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
                .from(ScoreCardBack9Activity.this)
                .inflate(R.layout.custom_back9_popup_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(ScoreCardBack9Activity.this);

        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        setAlertDialogBackgroundColor(alertDialog);
        configureAlertDialogSaveRoundButton(view);
        configureAlertDialogDoNotSaveRoundButton(view);

        alertDialog.show();
    }

    public void configureAlertDialogSaveRoundButton(@NonNull View view) {
        Button buttonSaveRound = view.findViewById(R.id.button_save_round);
        buttonSaveRound.setOnClickListener(v -> {
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

            Log.i("TOTAL SCORE ====> ", String.valueOf(userScore));

            scoreRepository.saveScore(ScoreCardBack9Activity.this, score);
            statsRepository.updateUserStats(statistics, user.getId());

            Intent goToHomeActivity = new Intent(ScoreCardBack9Activity.this,
                    HomeActivity.class);
            startActivity(goToHomeActivity);
        });
    }

    private int getUserScore() {
        int front9ParTotalSum = sumOfFront9Pars();
        int back9ParTotalSum = sumOfBack9Pars();
        int userScore = Integer.parseInt(binding.textViewCurrentScoreUser.getText().toString());

        return front9ParTotalSum + back9ParTotalSum + userScore;
    }

    private int sumOfBack9Pars() {
        int sum = 0;
        for (int i = 0; i < binding.getCourse().getBack9ParsList().size(); i++) {
            sum += i;
        }
        return sum;
    }

    private int sumOfFront9Pars() {
        int sum = 0;
        for (int i = 0; i < binding.getCourse().getFront9ParsList().size(); i++) {
            sum += i;
        }
        return sum;
    }

    public void configureAlertDialogDoNotSaveRoundButton(@NonNull View view) {
        Button buttonDoNotSaveRound = view.findViewById(R.id.button_do_not_save);

        buttonDoNotSaveRound.setOnClickListener(v -> {
            Intent goToHomeActivity = new Intent(ScoreCardBack9Activity.this,
                    HomeActivity.class);
            startActivity(goToHomeActivity);
        });
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
        int front9Score = Integer.parseInt(binding.textViewCurrentScoreUser.getText().toString());
        List<String> userScores = userScore.getListOFEnteredBack9Scores();
        List<Integer> pars = binding.getCourse().getBack9ParsList();

        for (int i = 0; i < userScores.size(); i++) {
            String score = userScores.get(i);
            int par = pars.get(i);

            if (score == null) {
                front9Score += 0;
            } else {
                front9Score += (Integer.parseInt(score) - par);
            }
        }

        textViewSumOfUserScores.setText(String.valueOf(front9Score));
    }

    @Override
    public void showGuest1Score(@NonNull Score guest1Score) {
        int front9Score = Integer.parseInt(binding.textViewCurrentScoreGuest1.getText().toString());
        List<String> userScores = guest1Score.getListOFEnteredBack9Scores();
        List<Integer> pars = binding.getCourse().getBack9ParsList();

        for (int i = 0; i < userScores.size(); i++) {
            String score = userScores.get(i);
            int par = pars.get(i);

            if (score == null) {
                front9Score += 0;
            } else {
                front9Score += (Integer.parseInt(score) - par);
            }
        }

        textViewSumOfGuest1Scores.setText(String.valueOf(front9Score));
    }

    @Override
    public void showGuest2Score(@NonNull Score showGuest2Score) {
        int front9Score = Integer.parseInt(binding.textViewCurrentScoreGuest2.getText().toString());
        List<String> userScores = showGuest2Score.getListOFEnteredBack9Scores();
        List<Integer> pars = binding.getCourse().getBack9ParsList();

        for (int i = 0; i < userScores.size(); i++) {
            String score = userScores.get(i);
            int par = pars.get(i);

            if (score == null) {
                front9Score += 0;
            } else {
                front9Score += (Integer.parseInt(score) - par);
            }
        }

        textViewSumOfGuest2Scores.setText(String.valueOf(front9Score));
    }

    @Override
    public void showGuest3Score(@NonNull Score showGuest3Score) {
        int front9Score = Integer.parseInt(binding.textViewCurrentScoreGuest3.getText().toString());
        List<String> userScores = showGuest3Score.getListOFEnteredBack9Scores();
        List<Integer> pars = binding.getCourse().getBack9ParsList();

        for (int i = 0; i < userScores.size(); i++) {
            String score = userScores.get(i);
            int par = pars.get(i);

            if (score == null) {
                front9Score += 0;
            } else {
                front9Score += (Integer.parseInt(score) - par);
            }
        }

        textViewSumOfGuest3Scores.setText(String.valueOf(front9Score));
    }
}