package com.example.gymdiary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import org.jetbrains.annotations.NotNull;

public class WorkoutPopup extends AppCompatDialogFragment {
    private EditText reps,series,poids;
    private WorkoutPopupListener Listener;

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.workpopup,null);

        builder.setView(view)
                .setTitle("Workoutpopup")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int r1 = Integer.parseInt(reps.getText().toString());
                        int r2 = Integer.parseInt(series.getText().toString());
                        int r3 = Integer.parseInt(poids.getText().toString());
                        Listener.applyTexts(r1,r2,r3);

                    }
                });

        reps = view.findViewById(R.id.reps);
        series = view.findViewById(R.id.série);
        poids = view.findViewById(R.id.poid);


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        try {
            Listener = (WorkoutPopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface  WorkoutPopupListener{
        default void applyTexts(int r1, int r2, int r3){



        }
    }
}
