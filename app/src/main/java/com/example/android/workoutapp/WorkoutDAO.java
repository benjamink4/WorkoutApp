package com.example.android.workoutapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorkoutDAO {
    @Query("SELECT * FROM workout_table") //getAll the workouts from the table, will be used in the ViewAll workouts
    List<Workout>getAll();

    @Query("SELECT * FROM workout_table WHERE WORKOUT_NAME LIKE :Workout_Name")
    Workout findWorkout(String Workout_Name);

    @Insert
    void insert(Workout workout);

    @Delete
    void Delte(Workout...workout);

    @Update
    void update(Workout...workouts);






}
