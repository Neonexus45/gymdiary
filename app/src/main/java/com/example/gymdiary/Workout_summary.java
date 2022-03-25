package com.example.gymdiary;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gymdiary.Adapter.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class Workout_summary extends AppCompatActivity {

    private RecyclerView tasksRecyclerView;
    private WorkoutAdapter adapter;

    private List<Workout> workoutList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);


        workoutList = new ArrayList<>();
        tasksRecyclerView = findViewById(R.id.recycleview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WorkoutAdapter(this);
        tasksRecyclerView.setAdapter(adapter);

        Workout workout1 = new Workout(1,1,1,"Choisir");
        Workout workout2 = new Workout(2,2,2,"Choisir");
        Workout workout3 = new Workout(3,3,3,"Choisir");
        Workout workout4 = new Workout(4,4,4,"Choisir");
        Workout workout5 = new Workout(5,5,5,"Choisir");
        Workout workout6 = new Workout(6,6,6,"Choisir");

        workoutList.add(workout1);
        workoutList.add(workout2);
        workoutList.add(workout3);
        workoutList.add(workout4);
        workoutList.add(workout5);
        workoutList.add(workout6);


        adapter.setWorkout(workoutList);





    }
}
