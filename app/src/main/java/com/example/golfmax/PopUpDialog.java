package com.example.golfmax;


import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Activities.LoginActivity;
import com.example.golfmax.R;
import com.example.golfmax.Requests.ScoreRequest;
import com.example.golfmax.Responses.ScoreResponse;
import com.example.golfmax.Models.User;
import com.google.android.material.textfield.TextInputLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopUpDialog extends AppCompatDialogFragment {

    TextInputLayout textInputCourseName, textInputScore, textInputCourseRating, textInputSlopeRating;
    ScoreRequest scoreRequest = new ScoreRequest();
    DBHelper db;
    User user;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.popup_dialog, null);

        textInputCourseName = view.findViewById(R.id.enterCourseName);
        textInputScore = view.findViewById(R.id.enterScore);
        textInputCourseRating = view.findViewById(R.id.enterCourseRating);
        textInputSlopeRating = view.findViewById(R.id.enterSlopeRating);

        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Add scores")
                .setPositiveButton("Save round", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button saveRound = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                saveRound.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String courseName = textInputCourseName.getEditText().getText().toString();
                        String userScore = textInputScore.getEditText().getText().toString();
                        String userCourseRating = textInputCourseRating.getEditText().getText().toString();
                        String userSlopeRating = textInputSlopeRating.getEditText().getText().toString();

                        if (TextUtils.isEmpty(courseName)) {
                            textInputCourseName.setError("Please do not leave empty.");
                        }
                        else if (TextUtils.isEmpty(userScore)) {
                            textInputScore.setError("Please do not leave empty.");
                        }
                        else if (TextUtils.isEmpty(userCourseRating)) {
                            textInputCourseRating.setError("Please do not leave empty.");
                        }
                        else if (TextUtils.isEmpty(userSlopeRating)) {
                            textInputSlopeRating.setError("Please do not leave empty.");
                        }
                        else {
                            int score = Integer.parseInt(userScore);
                            double courseRating = Double.parseDouble(userCourseRating);
                            double slopeRating = Double.parseDouble(userSlopeRating);

                            db = new DBHelper(getActivity());
                            user = new User();

                            user.setId(db.getUserId(LoginActivity.username));
                            scoreRequest.setCourseName(courseName);
                            scoreRequest.setUserScore(score);
                            scoreRequest.setCourseRating(courseRating);
                            scoreRequest.setSlopeRating(slopeRating);
                            scoreRequest.setUser(user);

                            saveRound(scoreRequest);
                        }
                    }
                });
            }
        }); return dialog;
    }

    public void saveRound(ScoreRequest scoreRequest) {
        Call<ScoreResponse> scoreResponseCall = ApiClient.getUserService().addScore(scoreRequest);
        scoreResponseCall.enqueue(new Callback<ScoreResponse>() {
            @Override
            public void onResponse(Call<ScoreResponse> call, Response<ScoreResponse> response) {
                if (response.isSuccessful()) {
                    dismiss();
                    Toast.makeText(getActivity(), "Score saved.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Failed.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ScoreResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}