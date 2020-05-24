package com.example.android.workoutapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Workout.class},version = 1)
public abstract class WorkoutDatabase extends RoomDatabase{
    private static final String DB_NAME = "WORKOUT_DB";

    public abstract WorkoutDAO workoutDAO();


}
