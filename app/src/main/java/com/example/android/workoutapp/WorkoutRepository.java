package com.example.android.workoutapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WorkoutRepository {

    private WorkoutDAO workoutDAO;
    private LiveData<List<Workout>> mAllWorkouts;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    WorkoutRepository(Application application) {
        WorkoutDatabase db = WorkoutDatabase.getDatabase(application);
        workoutDAO = db.workoutDAO();
        mAllWorkouts = workoutDAO.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Workout>> getAllWords() {
        return mAllWorkouts;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Workout workout) {
        WorkoutDatabase.databaseWriteExecutor.execute(() -> {
            workoutDAO.insert(workout);
        });
    }
}
