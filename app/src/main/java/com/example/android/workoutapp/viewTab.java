package com.example.android.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class viewTab extends Fragment {
    private ArrayList<Workout>workouts=new ArrayList<>();

    public viewTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //Sample data, delete when we can delete this view
        workouts.add(new Workout("Running","4/20/1969",342.3, 1, 2));
        workouts.add(new Workout("Running","4/20/1969",342.3, 1, 2));
        workouts.add(new Workout("Running","4/20/1969",342.3, 1, 2));
        workouts.add(new Workout("Running","4/20/1969",342.3, 1, 2));
        workouts.add(new Workout("Running","4/20/1969",342.3, 1, 2));



       View view= inflater.inflate(R.layout.fragment_view_tab2, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.WorkoutsRecyclerView);
        WorkoutsRecyclerView adapter =  new WorkoutsRecyclerView(getContext(),workouts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }



}
