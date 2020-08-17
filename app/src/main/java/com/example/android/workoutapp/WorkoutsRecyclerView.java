package com.example.android.workoutapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutsRecyclerView extends RecyclerView.Adapter<WorkoutsRecyclerView.WorkoutViewHolder> {


    private Context context;
    private List<Workout> workouts;
    public WorkoutsRecyclerView(Context context){
        this.context=context;

    }



    public class WorkoutViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        private TextView date;
        private TextView time;
        private TextView name;
        private TextView calories;

        public WorkoutViewHolder(View view){
            super(view);
            this.date= view.findViewById(R.id.Date);
            this.time= view.findViewById(R.id.Time);
            this.name= view.findViewById(R.id.Name);
            this.linearLayout = view.findViewById(R.id.LinearLayout);
            this.calories = view.findViewById(R.id.Calories);
        }
    }
    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_workout,parent,false);
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        final Workout workout = workouts.get(position);
        holder.name.setText(workouts.get(position).getWorkout_Name());
        holder.date.setText(workouts.get(position).getDate());
        holder.calories.setText(String.valueOf(workouts.get(position).getCalories()));
        holder.time.setText(String.valueOf(workouts.get(position).getHours())+"h "+String.valueOf(workouts.get(position).getMinutes())+"m");


    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    void setWorkoutArrayList(List<Workout>workouts){
        this.workouts = workouts;
        notifyDataSetChanged();

    }






}
