package com.example.gymdiary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gymdiary.Utils.RecyclerItemTouchHelper;
import com.example.gymdiary.Utils.WorkoutAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Workout_summary extends AppCompatActivity implements WorkoutPopup.WorkoutPopupListener {

    private RecyclerView tasksRecyclerView;
    private WorkoutAdapter adapter;
    private FloatingActionButton fab;
    private TextView jour;

    private List<Workout> workoutList;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Intent intent = getIntent();
        jour = findViewById(R.id.description);
        jour.setText("Le " + intent.getStringExtra("day" )+ "/" + intent.getStringExtra("month") + "/" + intent.getStringExtra("year"));




        workoutList = new ArrayList<>();
        workoutList.add(new Workout(0,0,0,""));


        tasksRecyclerView = findViewById(R.id.recycleview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WorkoutAdapter(this);
        tasksRecyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        fab.setOnClickListener(view -> createNeWorkout());
            adapter.setWorkout(workoutList);

    }

    private void createNeWorkout() {
        WorkoutPopup popup = new WorkoutPopup();
        popup.show(getSupportFragmentManager(),"test dialog");

    }

    @Override
    public void applyTexts(int r1, int r2, int r3) {
        workoutList.add(new Workout(r1,r2,r3,""));
    }
}
