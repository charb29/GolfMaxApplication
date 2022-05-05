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

    TextInputLayout TiScore, TiCourseRating, TiSlopeRating, TiCourse;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_pop_up_dialog, null);

        TiCourse = view.findViewById(R.id.enterCourseName);
        TiScore = view.findViewById(R.id.inputScore);
        TiCourseRating = view.findViewById(R.id.inputCourseRating);
        TiSlopeRating = view.findViewById(R.id.inputSlopeRating);
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
                        String courseName = TiCourse.getEditText().getText().toString();
                        String userScores = TiScore.getEditText().getText().toString();
                        String userCourseRating = TiCourseRating.getEditText().getText().toString();
                        String userSlopeRating = TiSlopeRating.getEditText().getText().toString();

                        if (TextUtils.isEmpty(courseName)) {
                            TiCourse.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userScores)) {
                            TiScore.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userCourseRating)) {
                            TiCourseRating.setError("Please do not leave empty");
                        }
                        else if (TextUtils.isEmpty(userSlopeRating)) {
                            TiSlopeRating.setError("Please do not leave empty");
                        }
                        else {
                            int saveScore = Integer.parseInt(userScores);
                            double saveCourseRating = Double.parseDouble(userCourseRating);
                            double saveSlopeRating = Double.parseDouble(userSlopeRating);

                            db.saveScores(courseName, saveScore, saveCourseRating, saveSlopeRating);
                            Toast.makeText(getActivity(), "Score has been saved", Toast.LENGTH_SHORT).show();

                            TiCourse.getEditText().setText("");
                            TiScore.getEditText().setText("");
                            TiCourseRating.getEditText().setText("");
                            TiSlopeRating.getEditText().setText("");
                            dialog.dismiss();
                        }
                    }
                });
            }
        }); return dialog;
    }
}
