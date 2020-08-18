package com.example.android.workoutapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WorkoutModel extends AndroidViewModel {
    private WorkoutRepository workoutRepository;
    private LiveData<List<Workout>>allWorkouts;

    public WorkoutModel(Application application){
        super(application);
        workoutRepository = new WorkoutRepository(application);
        allWorkouts = workoutRepository.getAllWords();
    }
    LiveData<List<Workout>> getAllWorkouts(){return allWorkouts;}
    void insert(Workout n){
        workoutRepository.insert(n);
    }
}
