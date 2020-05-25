package com.example.android.workoutapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "workout_table")
public class Workout {

    @PrimaryKey(autoGenerate = true)
    protected int id;


    @ColumnInfo (name="WORKOUT_NAME")
    private String Workout_Name;

    @ColumnInfo(name="DATE")
    private String date;

    @ColumnInfo(name="CALORIES")
    private double calories;

    @ColumnInfo(name="HOURS")
    private int hours;

    @ColumnInfo(name="MINUTES")
    private int minutes;;

    public Workout(String Workout_Name, String date, double calories, int hours, int minutes){
        this.Workout_Name=Workout_Name;
        this.date=date;
        this.calories=calories;
        this.hours=hours;
        this.minutes=minutes;
    }
    public String getWorkout_Name() {
        return Workout_Name;
    }

    public void setWorkout_Name(String workout_Name) {
        Workout_Name = workout_Name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    private int getId(){return id;}

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
