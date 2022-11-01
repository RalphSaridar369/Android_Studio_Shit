package com.example.caloriyat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public Intent i;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.i = new Intent(this,MainActivity3.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void calculateBMI (View v){
        EditText we = findViewById(R.id.weight);
        EditText he = findViewById(R.id.height);
        Double weight = Double.parseDouble(we.getText().toString());
        Double height = Double.parseDouble(he.getText().toString());

        Double BMI = weight / Math.pow(height/100,2);
        String results = "";

        if (BMI < 16){
            results = "severely underweight";
        }
        else if (BMI > 16 && BMI < 18.5){
            results = "underweight";
        }
        else if (BMI > 18.5 && BMI < 25){
            results = "normal";
        }
        else if (BMI > 25 && BMI < 30){
            results = "overweight";
        }
        else{
            results = "obese";
        }
        Toast toast=Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }

    public void howMuchShouldIeat(View v){
        EditText we = findViewById(R.id.weight);
        EditText he = findViewById(R.id.height);

        RadioGroup genderGroup = findViewById(R.id.radio_gender);
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        RadioButton radioGender = findViewById(selectedGenderId);
        String gender = radioGender.getText().toString();

        Boolean isMale = gender == "Male";


        Spinner ageSpinner =  findViewById(R.id.age);
        String age = ageSpinner.getSelectedItem().toString();

        Integer weight = Integer.parseInt(we.getText().toString());
        Integer height = Integer.parseInt(he.getText().toString());
        System.out.println("Gender " + gender + " " + age);



        if(isMale){
            System.out.print("Inside Male ");
            result = 665 + (6.3 * this.toPounds(weight)) + (12.9 * toInches(height)) - (6.8 * 24) + "";
        }

        if(!isMale && age=="Below 24"){
            System.out.print("Inside Female <24");
            result = 665 + (4.3 * this.toPounds(weight)) + (4.7 * toInches(height)) - (4.7 * 24)+ "";
        }

        if(!isMale && age=="Above 24"){
            System.out.print("Inside Female >24");
            result = 455 + (4.3 * this.toPounds(weight)) + (4.7 * toInches(height)) - (4.7 * 24)+ "";
        }


        Intent calories = i.putExtra("calories", result.toString());
        startActivity(calories);

    }

    public double toPounds (int weight_in_kg){
        return weight_in_kg * 2.20462;
    }
    public double toInches (int height_in_cm){
        return height_in_cm * 0.393701;
    }
}