package com.example.gymdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    private CalendarView calendrier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendrier = findViewById(R.id.calendrier);

        calendrier.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Intent intent = new Intent(MainActivity.this,Workout_summary.class);
                intent.putExtra("year",String.valueOf(i));
                intent.putExtra("month",String.valueOf(i1));
                intent.putExtra("day",String.valueOf(i2));

                startActivity(intent);

            }
        });
    }
}