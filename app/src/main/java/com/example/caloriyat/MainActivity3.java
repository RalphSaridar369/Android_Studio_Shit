package com.example.caloriyat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    protected void onResume() {
        super.onResume();
        String calories;
        Intent i = getIntent();
        System.out.print("Test");
        calories = i.getStringExtra("calories");
        System.out.print("calories "+calories);
        TextView endResult = findViewById(R.id.end_result);
        String stringResultForTV = "You need to eat " + calories.split("\\.")[0] + " calories per day";
        endResult.setText(stringResultForTV);
    }
}