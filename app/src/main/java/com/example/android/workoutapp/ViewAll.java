package com.example.android.workoutapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAll extends AppCompatActivity {
    private WorkoutModel workoutModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

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
}