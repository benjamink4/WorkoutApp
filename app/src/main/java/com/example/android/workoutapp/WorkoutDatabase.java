package com.example.android.workoutapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Workout.class},version = 1)
public abstract class WorkoutDatabase extends RoomDatabase{
    private static final String DB_NAME = "WORKOUT_DB";
    private static WorkoutDatabase instance;

    public abstract WorkoutDAO workoutDAO();
    public static synchronized WorkoutDatabase getInstance(Context context){ //only one thread could access that database at a time
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),WorkoutDatabase.class,DB_NAME)
            .fallbackToDestructiveMigration()
            .build();

        }
        return instance; //only instantiate dataBase if null

    }


}
