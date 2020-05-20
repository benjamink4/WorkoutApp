package com.example.android.workoutapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
    private EditText ETname;
    private EditText ETweight;
    private EditText ETfeet;
    private EditText ETinches;
    private RadioGroup RGender;
    private RadioButton male;
    private RadioButton female;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String WEIGHT ="WEIGHT";
    public static final String NAME ="NAME";
    public static final String FEET ="FEET";
    public static final String INCHES ="INCHES";
    public static final String MALE= "MALE";
    public static final String FEMALE= "FEMALE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ETname=(EditText)findViewById(R.id.Name);
        ETweight = (EditText)findViewById(R.id.Weight);
        ETinches = (EditText)findViewById(R.id.Inches);
        ETfeet = (EditText)findViewById(R.id.Feet);
        RGender = (RadioGroup)findViewById(R.id.SexRadioButtons);
        male = (RadioButton)findViewById(R.id.Male);
        female = (RadioButton )findViewById(R.id.Female);

        Button confirm = (Button)findViewById(R.id.Confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(ETname.getText().toString().length()==0
                        ||ETweight.getText().toString().length()==0
                        || ETinches.getText().toString().length()==0
                        || ETfeet.getText().toString().length()==0
                        || ETname.getText().toString().length()==0
                         || RGender.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Please fill out required information",Toast.LENGTH_SHORT).show();
                }else{
                    //sTORE THE DATA VALUES INTO A SHARED PREFENCE
                    saveData();

                }



            }
        });
        loadData();


    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME,ETname.getText().toString());
        editor.putString(WEIGHT, ETweight.getText().toString());

        editor.putString(FEET, ETfeet.getText().toString());
        editor.putString(INCHES, ETinches.getText().toString());


        editor.putBoolean(MALE,male.isChecked());
        editor.putBoolean(FEMALE,female.isChecked());

        editor.apply();


    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String n = sharedPreferences.getString(NAME," ");
        ETname.setText(n);

        //String w = sharedPreferences.getString(WEIGHT,"");
        ETweight.setText(sharedPreferences.getString(WEIGHT,""));

        ETfeet.setText(sharedPreferences.getString(FEET,""));
        ETinches.setText(sharedPreferences.getString(INCHES,""));

        male.setChecked(sharedPreferences.getBoolean(MALE,false));
        female.setChecked(sharedPreferences.getBoolean(FEMALE,false));



    }
    }




