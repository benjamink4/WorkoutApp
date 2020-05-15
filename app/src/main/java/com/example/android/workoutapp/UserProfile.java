package com.example.android.workoutapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
    EditText ETname;
    EditText ETweight;
    EditText ETfeet;
    EditText ETinches;
    RadioGroup RGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ETname=(EditText)findViewById(R.id.Name);
        ETweight = (EditText)findViewById(R.id.Weight);
        ETfeet = (EditText)findViewById(R.id.Feet);
        RGender = (RadioGroup) findViewById(R.id.SexRadioButtons);



        Button confirm = (Button)findViewById(R.id.Confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Male:
                if (checked)
                    Toast.makeText(this, "Male Clicked", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.Female:
                if (checked)
                    // Ninjas rule
                    Toast.makeText(this,"Female",Toast.LENGTH_SHORT).show();
                    break;
        }
    }


}
