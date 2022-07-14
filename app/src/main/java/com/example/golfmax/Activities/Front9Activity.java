package com.example.golfmax.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.R;
import com.example.golfmax.RecyclerViews.PlayRoundRV;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Front9Activity extends AppCompatActivity {

    TextView tvPar1, tvPar2, tvPar3, tvPar4, tvPar5, tvPar6, tvPar7, tvPar8, tvPar9;
    TextView tvUsername, tvCurrentScoreUser, tvCurrentScoreGuest1, tvCurrentScoreGuest2, tvCurrentScoreGuest3, tvCurrentScoreUser_name, tvCurrentScoreGuest1_name, tvCurrentScoreGuest2_name, tvCurrentScoreGuest3_name;
    TextInputEditText tiEtGuest1, tiEtGuest2, tiEtGuest3;
    EditText etUserHole1, etUserHole2, etUserHole3, etUserHole4, etUserHole5, etUserHole6, etUserHole7, etUserHole8, etUserHole9;
    EditText etGuest1Hole1, etGuest1Hole2, etGuest1Hole3, etGuest1Hole4, etGuest1Hole5, etGuest1Hole6, etGuest1Hole7, etGuest1Hole8, etGuest1Hole9;
    EditText etGuest2Hole1, etGuest2Hole2, etGuest2Hole3, etGuest2Hole4, etGuest2Hole5, etGuest2Hole6, etGuest2Hole7, etGuest2Hole8, etGuest2Hole9;
    EditText etGuest3Hole1, etGuest3Hole2, etGuest3Hole3, etGuest3Hole4, etGuest3Hole5, etGuest3Hole6, etGuest3Hole7, etGuest3Hole8, etGuest3Hole9;
    DBHelper db;
    Course course;
    long courseId;
    int userSumOfHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front9);
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

        tvUsername = findViewById(R.id.text_view_username);
        tiEtGuest1 = findViewById(R.id.text_input_edit_text_guest1);
        tiEtGuest2 = findViewById(R.id.text_input_edit_text_guest2);
        tiEtGuest3 = findViewById(R.id.text_input_edit_text_guest3);

        etUserHole1 = findViewById(R.id.edit_text_hole1);
        etUserHole2 = findViewById(R.id.edit_text_hole2);
        etUserHole3 = findViewById(R.id.edit_text_hole3);
        etUserHole4 = findViewById(R.id.edit_text_hole4);
        etUserHole5 = findViewById(R.id.edit_text_hole5);
        etUserHole6 = findViewById(R.id.edit_text_hole6);
        etUserHole7 = findViewById(R.id.edit_text_hole7);
        etUserHole8 = findViewById(R.id.edit_text_hole8);
        etUserHole9 = findViewById(R.id.edit_text_hole9);

        etGuest1Hole1 = findViewById(R.id.edit_text_hole1_guest1);
        etGuest1Hole2 = findViewById(R.id.edit_text_hole2_guest1);
        etGuest1Hole3 = findViewById(R.id.edit_text_hole3_guest1);
        etGuest1Hole4 = findViewById(R.id.edit_text_hole4_guest1);
        etGuest1Hole5 = findViewById(R.id.edit_text_hole5_guest1);
        etGuest1Hole6 = findViewById(R.id.edit_text_hole6_guest1);
        etGuest1Hole7 = findViewById(R.id.edit_text_hole7_guest1);
        etGuest1Hole8 = findViewById(R.id.edit_text_hole8_guest1);
        etGuest1Hole9 = findViewById(R.id.edit_text_hole9_guest1);

        etGuest2Hole1 = findViewById(R.id.edit_text_hole1_guest2);
        etGuest2Hole2 = findViewById(R.id.edit_text_hole2_guest2);
        etGuest2Hole3 = findViewById(R.id.edit_text_hole3_guest2);
        etGuest2Hole4 = findViewById(R.id.edit_text_hole4_guest2);
        etGuest2Hole5 = findViewById(R.id.edit_text_hole5_guest2);
        etGuest2Hole6 = findViewById(R.id.edit_text_hole6_guest2);
        etGuest2Hole7 = findViewById(R.id.edit_text_hole7_guest2);
        etGuest2Hole8 = findViewById(R.id.edit_text_hole8_guest2);
        etGuest2Hole9 = findViewById(R.id.edit_text_hole9_guest2);

        etGuest3Hole1 = findViewById(R.id.edit_text_hole1_guest3);
        etGuest3Hole2 = findViewById(R.id.edit_text_hole2_guest3);
        etGuest3Hole3 = findViewById(R.id.edit_text_hole3_guest3);
        etGuest3Hole4 = findViewById(R.id.edit_text_hole4_guest3);
        etGuest3Hole5 = findViewById(R.id.edit_text_hole5_guest3);
        etGuest3Hole6 = findViewById(R.id.edit_text_hole6_guest3);
        etGuest3Hole7 = findViewById(R.id.edit_text_hole7_guest3);
        etGuest3Hole8 = findViewById(R.id.edit_text_hole8_guest3);
        etGuest3Hole9 = findViewById(R.id.edit_text_hole9_guest3);

        tvCurrentScoreUser = findViewById(R.id.text_view_current_score_user);
        tvCurrentScoreGuest1 = findViewById(R.id.text_view_current_score_guest1);
        tvCurrentScoreGuest2 = findViewById(R.id.text_view_current_score_guest2);
        tvCurrentScoreGuest3 = findViewById(R.id.text_view_current_score_guest3);

        tvCurrentScoreUser_name = findViewById(R.id.text_view_current_score_username);
        tvCurrentScoreGuest1_name = findViewById(R.id.text_view_current_score_guest1_name);
        tvCurrentScoreGuest2_name = findViewById(R.id.text_view_current_score_guest2_name);
        tvCurrentScoreGuest3_name = findViewById(R.id.text_view_current_score_guest3_name);

        tvUsername.setText(LoginActivity.username);
        tvCurrentScoreUser_name.setText(LoginActivity.username);

        tiEtGuest1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvCurrentScoreGuest1_name.setText(tiEtGuest1.getText().toString());
                return true;
            }
        });

        tiEtGuest2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvCurrentScoreGuest2_name.setText(tiEtGuest2.getText().toString());
                return true;
            }
        });

        tiEtGuest3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvCurrentScoreGuest3_name.setText(tiEtGuest3.getText().toString());
                return true;
            }
        });


        db = new DBHelper(this);
        course = new Course();
        course.setId(db.getCourseId(PlayRoundRV.courseNameForTextView));
        courseId = course.getId();

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

    
}