package com.example.android.workoutapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorkoutDAO {
    @Query("SELECT * FROM workout_table") //getAll the workouts from the table, will be used in the ViewAll workouts
    LiveData<List<Workout>>getAll();

    @Query("SELECT * FROM workout_table WHERE WORKOUT_NAME LIKE :Workout_Name")
    Workout findWorkout(String Workout_Name); //find a particuluar workout

    @Insert
    void insert(Workout workout);

    @Delete
    void Delete(Workout workout);

    @Update
    void update(Workout...workouts);






}
