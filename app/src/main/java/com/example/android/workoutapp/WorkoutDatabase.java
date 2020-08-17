package com.example.android.workoutapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



//Source: https://medium.com/mindorks/using-room-database-android-jetpack-675a89a0e942
@Database(entities = {Workout.class}, version = 1, exportSchema = false)
public abstract class WorkoutDatabase extends RoomDatabase {

    public abstract WorkoutDAO workoutDAO();

    private static volatile WorkoutDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WorkoutDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WorkoutDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WorkoutDatabase.class, "workout_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
