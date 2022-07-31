package com.example.golfmaxfinal.activities;


import android.app.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.CourseRepository;
import com.example.golfmaxfinal.backend.GolfMaxLocalDatabase;
import com.example.golfmaxfinal.contracts.ScoreContract;
import com.example.golfmaxfinal.databinding.ActivityScoreCardFront9Binding;
import com.example.golfmaxfinal.models.Course;
import com.example.golfmaxfinal.models.Score;
import com.example.golfmaxfinal.models.User;
import com.example.golfmaxfinal.presenters.ScorePresenter;
import com.example.golfmaxfinal.recyclerViews.NewRoundRV;

import java.util.ArrayList;
import java.util.List;


public class ScoreCardFront9Activity extends Activity implements ScoreContract.View {

    ActivityScoreCardFront9Binding binding;
    TextView tvSumOfUserScores, tvSumOfGuest1Scores, tvSumOfGuest2Scores, tvSumOfGuest3Scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_score_card_front9);

        tvSumOfUserScores = findViewById(R.id.text_view_current_score_user);
        tvSumOfGuest1Scores = findViewById(R.id.text_view_current_score_guest1);
        tvSumOfGuest2Scores = findViewById(R.id.text_view_current_score_guest2);
        tvSumOfGuest3Scores = findViewById(R.id.text_view_current_score_guest3);

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
        user.setUsername(LoginActivity.staticUsername);

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

    public long getCourseIdByCourseName(String courseName) {
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

        tvSumOfUserScores.setText(String.valueOf(scoreSummary));
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

        tvSumOfGuest1Scores.setText(String.valueOf(scoreSummary));
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

        tvSumOfGuest2Scores.setText(String.valueOf(scoreSummary));
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

        tvSumOfGuest3Scores.setText(String.valueOf(scoreSummary));
    }
}