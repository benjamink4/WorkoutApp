package com.example.android.workoutapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */

public class addTab extends Fragment  {
    private static final double BURN_CONST=0.0175;
    private TextView workoutName;
    private TextView caloriesBurned;
    private EditText hours;
    private EditText minutes;
    private Button button;



    public addTab() {
        // Required empty public constructor
    }




     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_add_tab2, container, false);
        workoutName = (TextView) view.findViewById(R.id.Workout_Name);
        Intent intent = getActivity().getIntent();
        workoutName.setText(intent.getExtras().getString("WORKOUT_NAME"));
        caloriesBurned = (TextView)view.findViewById(R.id.CaloriesBurned);
        hours = (EditText)view.findViewById(R.id.Hours);
        int h;
        if(hours.getText().toString().length()==0){
            h=0;
        }

        minutes =(EditText)view.findViewById(R.id.Minutes);
        button = (Button)view.findViewById(R.id.CaloriesCalculator);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences("sharedPrefs", getContext().MODE_PRIVATE);
                int weight =  Integer.parseInt(sharedPreferences.getString("WEIGHT", "0"));
                Toast.makeText(getContext(),workoutName.getText().toString(),Toast.LENGTH_SHORT).show();

                int time = Integer.parseInt(hours.getText().toString())*60+Integer.parseInt(minutes.getText().toString());
                caloriesBurned.setText(String.valueOf(EstimateCalories(workoutName.getText().toString(),weight,time)));

            }
        });







        return view;
    }


    private double convertToKilos(int pounds) {
        return pounds*0.453592;


    }


    public double EstimateCalories(String activity,int weight,int time) {
        //Energy expenditure (calories/minute) = .0175 x MET (from table) x weight (in kilograms)
        //Source:https://www.hss.edu/conditions_burning-calories-with-exercise-calculating-estimated-energy-expenditure.asp
        double kilo_weight = convertToKilos(weight);
        double n = kilo_weight*BURN_CONST*time;
        switch(activity){
            case "Running":
                return n*10;
            case "Swimming":
                return n*5.8;
            case "Cycling":
                return n*7.5;
            case "Lifting":
                return n*6.0;
            case "Baseball":
                return n*5.0;
            case "Football":
                return n*8.0;
            case "Soccer":
                return n*7.0;
            case "Hockey":
                return n*7.8;
            case "Basketball":
                return n*6.5;
            case "Tennis":
                return n*7.3;
            default:
                return 0;


        }

    }






}

