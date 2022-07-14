package com.example.golfmax.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.CourseListRV;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Front9Activity extends AppCompatActivity {

    TextView tvPar1, tvPar2, tvPar3, tvPar4, tvPar5, tvPar6, tvPar7, tvPar8, tvPar9;
    TextInputEditText tiEtGuest1Name, tiEtGuest2Name, tiEtGuest3Name;
    TextView tvUsername, tvCurrentScoreUser, tvCurrentScoreGuest1, tvCurrentScoreGuest2, tvCurrentScoreGuest3, tvCurrentScoreUsername, tvGuest1Name, tvGuest2Name, tvGuest3Name;
    EditText etUserScoreHole1, etUserScoreHole2, etUserScoreHole3, etUserScoreHole4, etUserScoreHole5, etUserScoreHole6, etUserScoreHole7, etUserScoreHole8, etUserScoreHole9;
    EditText etGuest1ScoreHole1, etGuest1ScoreHole2, etGuest1ScoreHole3, etGuest1ScoreHole4, etGuest1ScoreHole5, etGuest1ScoreHole6, etGuest1ScoreHole7, etGuest1ScoreHole8, etGuest1ScoreHole9;
    EditText etGuest2ScoreHole1, etGuest2ScoreHole2, etGuest2ScoreHole3, etGuest2ScoreHole4, etGuest2ScoreHole5, etGuest2ScoreHole6, etGuest2ScoreHole7, etGuest2ScoreHole8, etGuest2ScoreHole9;
    EditText etGuest3ScoreHole1, etGuest3ScoreHole2, etGuest3ScoreHole3, etGuest3ScoreHole4, etGuest3ScoreHole5, etGuest3ScoreHole6, etGuest3ScoreHole7, etGuest3ScoreHole8, etGuest3ScoreHole9;
    int userSumOfHoles = 0;
    int guest1SumOfHoles = 0;
    int guest2SumOfHoles = 0;
    int guest3SumOfHoles = 0;
    DBHelper db;
    Course course;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setTitle("");

        tvPar1 = findViewById(R.id.text_view_par1);
        tvPar2 = findViewById(R.id.text_view_par2);
        tvPar3 = findViewById(R.id.text_view_par3);
        tvPar4 = findViewById(R.id.text_view_par4);
        tvPar5 = findViewById(R.id.text_view_par5);
        tvPar6 = findViewById(R.id.text_view_par6);
        tvPar7 = findViewById(R.id.text_view_par7);
        tvPar8 = findViewById(R.id.text_view_par8);
        tvPar9 = findViewById(R.id.text_view_par9);

        tvCurrentScoreUsername = findViewById(R.id.text_view_current_score_username);
        tvGuest1Name = findViewById(R.id.text_view_current_score_guest1_name);
        tvGuest2Name = findViewById(R.id.text_view_current_score_guest2_name);
        tvGuest3Name = findViewById(R.id.text_view_current_score_guest3_name);

        tvCurrentScoreUser = findViewById(R.id.text_view_current_score_user);
        tvCurrentScoreGuest1 = findViewById(R.id.text_view_current_score_guest1);
        tvCurrentScoreGuest2 = findViewById(R.id.text_view_current_score_guest2);
        tvCurrentScoreGuest3 = findViewById(R.id.text_view_current_score_guest3);

        tvUsername = findViewById(R.id.text_view_username);
        tiEtGuest1Name = findViewById(R.id.text_input_edit_text_guest1);
        tiEtGuest2Name = findViewById(R.id.text_input_edit_text_guest2);
        tiEtGuest3Name = findViewById(R.id.text_input_edit_text_guest3);

        tvUsername.setText(LoginActivity.username);
        tvCurrentScoreUsername.setText(LoginActivity.username);
        tiEtGuest1Name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvGuest1Name.setText(tiEtGuest1Name.getText().toString());
                return true;
            }
        });
        tiEtGuest2Name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvGuest2Name.setText(tiEtGuest2Name.getText().toString());
                return true;
            }
        });
        tiEtGuest3Name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvGuest3Name.setText(tiEtGuest3Name.getText().toString());
                return true;
            }
        });

        etUserScoreHole1 = findViewById(R.id.edit_text_hole1);
        etUserScoreHole2 = findViewById(R.id.edit_text_hole2);
        etUserScoreHole3 = findViewById(R.id.edit_text_hole3);
        etUserScoreHole4 = findViewById(R.id.edit_text_hole4);
        etUserScoreHole5 = findViewById(R.id.edit_text_hole5);
        etUserScoreHole6 = findViewById(R.id.edit_text_hole6);
        etUserScoreHole7 = findViewById(R.id.edit_text_hole7);
        etUserScoreHole8 = findViewById(R.id.edit_text_hole8);
        etUserScoreHole9 = findViewById(R.id.edit_text_hole9);

        etGuest1ScoreHole1 = findViewById(R.id.edit_text_hole1_guest1);
        etGuest1ScoreHole2 = findViewById(R.id.edit_text_hole2_guest1);
        etGuest1ScoreHole3 = findViewById(R.id.edit_text_hole3_guest1);
        etGuest1ScoreHole4 = findViewById(R.id.edit_text_hole4_guest1);
        etGuest1ScoreHole5 = findViewById(R.id.edit_text_hole5_guest1);
        etGuest1ScoreHole6 = findViewById(R.id.edit_text_hole6_guest1);
        etGuest1ScoreHole7 = findViewById(R.id.edit_text_hole7_guest1);
        etGuest1ScoreHole8 = findViewById(R.id.edit_text_hole8_guest1);
        etGuest1ScoreHole9 = findViewById(R.id.edit_text_hole9_guest1);

        etGuest2ScoreHole1 = findViewById(R.id.edit_text_hole1_guest2);
        etGuest2ScoreHole2 = findViewById(R.id.edit_text_hole2_guest2);
        etGuest2ScoreHole3 = findViewById(R.id.edit_text_hole3_guest2);
        etGuest2ScoreHole4 = findViewById(R.id.edit_text_hole4_guest2);
        etGuest2ScoreHole5 = findViewById(R.id.edit_text_hole5_guest2);
        etGuest2ScoreHole6 = findViewById(R.id.edit_text_hole6_guest2);
        etGuest2ScoreHole7 = findViewById(R.id.edit_text_hole7_guest2);
        etGuest2ScoreHole8 = findViewById(R.id.edit_text_hole8_guest2);
        etGuest2ScoreHole9 = findViewById(R.id.edit_text_hole9_guest2);

        etGuest3ScoreHole1 = findViewById(R.id.edit_text_hole1_guest3);
        etGuest3ScoreHole2 = findViewById(R.id.edit_text_hole2_guest3);
        etGuest3ScoreHole3 = findViewById(R.id.edit_text_hole3_guest3);
        etGuest3ScoreHole4 = findViewById(R.id.edit_text_hole4_guest3);
        etGuest3ScoreHole5 = findViewById(R.id.edit_text_hole5_guest3);
        etGuest3ScoreHole6 = findViewById(R.id.edit_text_hole6_guest3);
        etGuest3ScoreHole7 = findViewById(R.id.edit_text_hole7_guest3);
        etGuest3ScoreHole8 = findViewById(R.id.edit_text_hole8_guest3);
        etGuest3ScoreHole9 = findViewById(R.id.edit_text_hole9_guest3);

        List<EditText> userScores = new ArrayList<>();
        userScores.add(etUserScoreHole1);
        userScores.add(etUserScoreHole2);
        userScores.add(etUserScoreHole3);
        userScores.add(etUserScoreHole4);
        userScores.add(etUserScoreHole5);
        userScores.add(etUserScoreHole6);
        userScores.add(etUserScoreHole7);
        userScores.add(etUserScoreHole8);
        userScores.add(etUserScoreHole9);

        List<EditText> guest1Scores = new ArrayList<>();
        guest1Scores.add(etGuest1ScoreHole1);
        guest1Scores.add(etGuest1ScoreHole2);
        guest1Scores.add(etGuest1ScoreHole3);
        guest1Scores.add(etGuest1ScoreHole4);
        guest1Scores.add(etGuest1ScoreHole5);
        guest1Scores.add(etGuest1ScoreHole6);
        guest1Scores.add(etGuest1ScoreHole7);
        guest1Scores.add(etGuest1ScoreHole8);
        guest1Scores.add(etGuest1ScoreHole9);

        List<EditText> guest2Scores = new ArrayList<>();
        guest1Scores.add(etGuest2ScoreHole1);
        guest1Scores.add(etGuest2ScoreHole2);
        guest1Scores.add(etGuest2ScoreHole3);
        guest1Scores.add(etGuest2ScoreHole4);
        guest1Scores.add(etGuest2ScoreHole5);
        guest1Scores.add(etGuest2ScoreHole6);
        guest1Scores.add(etGuest2ScoreHole7);
        guest1Scores.add(etGuest2ScoreHole8);
        guest1Scores.add(etGuest2ScoreHole9);

        List<EditText> guest3Scores = new ArrayList<>();
        guest1Scores.add(etGuest3ScoreHole1);
        guest1Scores.add(etGuest3ScoreHole2);
        guest1Scores.add(etGuest3ScoreHole3);
        guest1Scores.add(etGuest3ScoreHole4);
        guest1Scores.add(etGuest3ScoreHole5);
        guest1Scores.add(etGuest3ScoreHole6);
        guest1Scores.add(etGuest3ScoreHole7);
        guest1Scores.add(etGuest3ScoreHole8);
        guest1Scores.add(etGuest3ScoreHole9);

        long courseId = getCourseIdByCourseName(CourseListRV.courseNameForTextView);

        calculateAndDisplayUserScores(userScores);
        calculateAndDisplayGuest1Scores(guest1Scores);
        calculateAndDisplayGuest2Scores(guest2Scores);
        calculateAndDisplayGuest3Scores(guest3Scores);
        populateCourseHolesByCourseId(courseId);
    }

    public long getCourseIdByCourseName(String username) {
        db = new DBHelper(this);
        course = new Course();
        course.setId(db.getCourseId(username));
        long courseId = course.getId();

        return courseId;
    }

    public void populateCourseHolesByCourseId(long courseId) {
        ApiClient.getUserService().getCourseById(courseId).enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                course = response.body();

                tvPar1.setText(String.valueOf(course.getHole1()));
                tvPar2.setText(String.valueOf(course.getHole2()));
                tvPar3.setText(String.valueOf(course.getHole3()));
                tvPar4.setText(String.valueOf(course.getHole4()));
                tvPar5.setText(String.valueOf(course.getHole5()));
                tvPar6.setText(String.valueOf(course.getHole6()));
                tvPar7.setText(String.valueOf(course.getHole7()));
                tvPar8.setText(String.valueOf(course.getHole8()));
                tvPar9.setText(String.valueOf(course.getHole9()));

                Log.i("COURSE INFO ====> ", course.toString());
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Log.e("FAIL ====> ", t.toString());
            }
        });
    }

    public void calculateAndDisplayUserScores(@NonNull List<EditText> scores) {
        List<Integer> coursePars = new ArrayList<>();
        coursePars.add(Integer.parseInt(tvPar1.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar2.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar3.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar4.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar5.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar6.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar7.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar8.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar9.getText().toString()));

        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    int userScoresIndex = scores.indexOf(v);

                    if (userScoresIndex >= 0) {
                        Log.e("ERROR ====> ", String.valueOf(userScoresIndex));
                        int holeParRating = coursePars.get(userScoresIndex);
                        userSumOfHoles += Integer.parseInt(v.getText().toString()) - holeParRating;
                        tvCurrentScoreUser.setText(String.valueOf(userSumOfHoles));
                    } else {
                        Log.e("ERROR ====> ", String.valueOf(userSumOfHoles));
                    }
                    return false;
                }
            });
        }
    }

    public void calculateAndDisplayGuest1Scores(@NonNull List<EditText> scores) {
        List<Integer> coursePars = new ArrayList<>();
        coursePars.add(Integer.parseInt(tvPar1.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar2.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar3.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar4.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar5.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar6.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar7.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar8.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar9.getText().toString()));

        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    int userScoresIndex = scores.indexOf(v);

                    if (userScoresIndex >= 0) {
                        Log.e("ERROR ====> ", String.valueOf(userScoresIndex));
                        int holeParRating = coursePars.get(userScoresIndex);
                        guest1SumOfHoles += Integer.parseInt(v.getText().toString()) - holeParRating;
                        tvCurrentScoreGuest1.setText(String.valueOf(guest1SumOfHoles));
                    } else {
                        Log.e("ERROR ====> ", String.valueOf(guest1SumOfHoles));
                    }
                    return false;
                }
            });
        }
    }

    public void calculateAndDisplayGuest2Scores(@NonNull List<EditText> scores) {
        List<Integer> coursePars = new ArrayList<>();
        coursePars.add(Integer.parseInt(tvPar1.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar2.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar3.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar4.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar5.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar6.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar7.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar8.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar9.getText().toString()));

        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    int userScoresIndex = scores.indexOf(v);

                    if (userScoresIndex >= 0) {
                        Log.e("ERROR ====> ", String.valueOf(userScoresIndex));
                        int holeParRating = coursePars.get(userScoresIndex);
                        guest2SumOfHoles += Integer.parseInt(v.getText().toString()) - holeParRating;
                        tvCurrentScoreGuest2.setText(String.valueOf(guest2SumOfHoles));
                    } else {
                        Log.e("ERROR ====> ", String.valueOf(guest2SumOfHoles));
                    }
                    return false;
                }
            });
        }
    }

    public void calculateAndDisplayGuest3Scores(@NonNull List<EditText> scores) {
        List<Integer> coursePars = new ArrayList<>();
        coursePars.add(Integer.parseInt(tvPar1.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar2.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar3.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar4.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar5.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar6.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar7.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar8.getText().toString()));
        coursePars.add(Integer.parseInt(tvPar9.getText().toString()));

        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    int userScoresIndex = scores.indexOf(v);

                    if (userScoresIndex >= 0) {
                        Log.e("ERROR ====> ", String.valueOf(userScoresIndex));
                        int holeParRating = coursePars.get(userScoresIndex);
                        guest3SumOfHoles += Integer.parseInt(v.getText().toString()) - holeParRating;
                        tvCurrentScoreGuest3.setText(String.valueOf(guest3SumOfHoles));
                    } else {
                        Log.e("ERROR ====> ", String.valueOf(guest3SumOfHoles));
                    }
                    return false;
                }
            });
        }
    }
}