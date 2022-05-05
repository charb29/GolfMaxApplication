package com.example.golfmax;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.textfield.TextInputLayout;

public class PopUpDialogActivity extends AppCompatDialogFragment {

    TextInputLayout textInputScore, textInputCourseRating, textInputSlopeRating, textInputCourseName;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_pop_up_dialog, null);

        textInputCourseName = view.findViewById(R.id.enterCourseName);
        textInputScore = view.findViewById(R.id.inputScore);
        textInputCourseRating = view.findViewById(R.id.inputCourseRating);
        textInputSlopeRating = view.findViewById(R.id.inputSlopeRating);
        DBHelper db = new DBHelper(getActivity());

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
                        String userScores = textInputScore.getEditText().getText().toString();
                        String userCourseRating = textInputCourseRating.getEditText().getText().toString();
                        String userSlopeRating = textInputSlopeRating.getEditText().getText().toString();

                        if (TextUtils.isEmpty(courseName)) {
                            textInputCourseName.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userScores)) {
                            textInputScore.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userCourseRating)) {
                            textInputCourseRating.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userSlopeRating)) {
                            textInputSlopeRating.setError("Please do not leave empty");
                        }
                        else {
                            int userScore = Integer.parseInt(userScores);
                            double courseRating = Double.parseDouble(userCourseRating);
                            double slopeRating = Double.parseDouble(userSlopeRating);

                            db.saveScores(courseName, userScore, courseRating, slopeRating);
                            Toast.makeText(getActivity(), "Score has been saved", Toast.LENGTH_SHORT).show();

                            textInputCourseName.getEditText().setText("");
                            textInputScore.getEditText().setText("");
                            textInputCourseRating.getEditText().setText("");
                            textInputSlopeRating.getEditText().setText("");
                            dialog.dismiss();
                        }
                    }
                });
            }
        }); return dialog;
    }
}
