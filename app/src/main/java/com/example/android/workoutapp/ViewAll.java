package com.example.android.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAll extends AppCompatActivity {
    private WorkoutModel workoutModel;
    public static final int NEW_WORKOUT_ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        RecyclerView recyclerView = findViewById(R.id.ViewRecyclerView);
        final WorkoutsRecyclerView adapter = new WorkoutsRecyclerView(this.getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        workoutModel = new ViewModelProvider(this).get(WorkoutModel.class);
        workoutModel.getAllWorkouts().observe(this, new Observer<List<Workout>>() {
            @Override
            public void onChanged(List<Workout> workouts) {
                adapter.setWorkoutArrayList(workouts);
            }
        });




    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORKOUT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Workout workout = new Workout(data.getStringExtra("WORKOUT"),data.getStringExtra("DATE"),data.getDoubleExtra("CALORIES",0),data.getIntExtra("HOURS",0),data.getIntExtra("MINUTES",0));
            workoutModel.insert(workout);
            Toast.makeText(getApplicationContext(),"SAVED",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"NOT SAVED",Toast.LENGTH_LONG).show();
        }
    }

}