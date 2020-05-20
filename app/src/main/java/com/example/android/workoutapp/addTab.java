package com.example.android.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class addTab extends Fragment {
    private EditText workoutName;


    public addTab() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_add_tab2, container, false);
        workoutName = (EditText) view.findViewById(R.id.Workout_Name);
        Intent intent = getActivity().getIntent();
        workoutName.setText(intent.getExtras().getString("WORKOUT_NAME"));




        return view;
    }
}
