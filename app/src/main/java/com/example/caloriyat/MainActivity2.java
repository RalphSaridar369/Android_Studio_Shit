package com.example.caloriyat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = new Intent(this,MainActivity3.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void calculateBMI (View v){
        EditText we = findViewById(R.id.weight);
        EditText he = findViewById(R.id.height);

        Double weight = Double.parseDouble(we.getText().toString());
        Double height = Double.parseDouble(he.getText().toString());

        Double BMI = weight / (height * height);
        String result = "";

        if (BMI < 16){
            result = "severely underweight";
        }
        else if (BMI > 16 && BMI < 18.5){
            result = "underweight";
        }
        else if (BMI > 18.5 && BMI < 25){
            result = "normal";
        }
        else if (BMI > 25 && BMI < 30){
            result = "overweight";
        }
        else{
            result = "obese";
        }
        Toast toast=Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }

    public void howMuchShouldIeat(View v){
        EditText we = findViewById(R.id.weight);
        EditText he = findViewById(R.id.height);

        Integer weight = Integer.parseInt(we.getText().toString());
        Integer height = Integer.parseInt(he.getText().toString());

        Double result;

        if("men"=="men"){
            result = 665 + (6.3 * this.toPounds(weight)) + (12.9 * toInches(height)) - (6.8 * 24);
        }

        else if("women"=="below 24"){
            result = 665 + (4.3 * this.toPounds(weight)) + (4.7 * toInches(height)) - (4.7 * 24);
        }

        else if("women"=="above 24"){
            result = 455 + (4.3 * this.toPounds(weight)) + (4.7 * toInches(height)) - (4.7 * 24);
        }

//        i.putExtra("calories",result+"");
//        startActivity(i);

    }

    public double toPounds (int weight_in_kg){
        return weight_in_kg * 2.20462;
    }
    public double toInches (int height_in_cm){
        return height_in_cm * 0.393701;
    }
}