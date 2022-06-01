package com.example.golfmax;

import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;


public class TestDialog extends AppCompatDialogFragment {

    TextInputLayout textInputScore;
    Spinner spinner;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.test, null);

        textInputScore = view.findViewById(R.id.enterScore);
        spinner = view.findViewById(R.id.spinnerCourses);

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
                        String userScore = textInputScore.getEditText().getText().toString();

                        if (TextUtils.isEmpty(userScore)) {
                            textInputScore.setError("Please do not leave empty.");
                        }

                        else {
                            int score = Integer.parseInt(userScore);

                        }
                    }
                });
            }
        }); return dialog;
    }
}