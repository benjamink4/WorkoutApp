package com.example.android.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewAndAdd extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem addTab, viewTab;
    public PageAdapter pagerAdapter;


    private static final double BURN_CONST = 0.0175;
    private TextView workoutName;
    private TextView caloriesBurned;
    private EditText hours;
    private EditText minutes;
    private Button button;
    private Button DatabaseSaver;
    private ArrayList<Workout> workouts = new ArrayList<>();
    public static final String EXTRA_REPLY = "com.example.android.workoutlistsql.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_and_view);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewTab = (TabItem) findViewById(R.id.ViewWorkouts);
        addTab = (TabItem) findViewById(R.id.AddWorkout);
        viewPager = findViewById(R.id.viewpager);


        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        workoutName = (TextView) findViewById(R.id.Workout_Name);

        //workoutName.setText(intent.getExtras().getString("WORKOUT_NAME"));
        caloriesBurned = (TextView) findViewById(R.id.CaloriesBurned);
        hours = (EditText) findViewById(R.id.Hours);

        minutes = (EditText)findViewById(R.id.Minutes);


        button = (Button) findViewById(R.id.CaloriesCalculator);
        DatabaseSaver = (Button) findViewById(R.id.DatabaseSaver);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                } else {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        DatabaseSaver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                int h = 0;
                if (hours.getText().toString().length() == 0) {
                    h = 0;
                } else {
                    h = Integer.parseInt(hours.getText().toString());
                }
                int m = 0;
                if (minutes.getText().toString().length() == 0) {
                    m = 0;
                } else {
                    m = Integer.parseInt(minutes.getText().toString());
                }
                String  pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());

                Workout n=new Workout(workoutName.getText().toString(),date,Double.parseDouble(caloriesBurned.getText().toString()),h,m);
                replyIntent.putExtra("WORKOUT", (Parcelable) n);
                setResult(RESULT_OK,replyIntent);
                finish();






            }
        });


    }
}