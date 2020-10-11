package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float height, weight;

    EditText height_input;
    EditText weight_input;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height_input = findViewById(R.id.height_input);
        weight_input = findViewById(R.id.weight_input);

        result = findViewById(R.id.result);

        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateBMI();
            }
        });
    }
    private void CalculateBMI(){
            height = Float.valueOf(height_input.getText().toString());
            weight = Float.valueOf(weight_input.getText().toString());

            if (height != 0 && weight != 0){
                float bmi = weight / (height * height);
                displayBMI (bmi);
            }
        }

        private void displayBMI (float bmi){
            String bmiMessage = "";

            if (bmi < 18.5){
                bmiMessage = "You are underweight";
            }
            else if (bmi > 18.5 && bmi < 24.9){
                bmiMessage = "You are in a healthy weight";
            }
            else if (bmi > 25 && bmi < 29.9){
                bmiMessage = "You are overweight";
            }
            else if (bmi > 30 && bmi < 39.9) {
                bmiMessage = "You are obese";
            }
            else {
            }
            bmiMessage = bmi + "\n" + bmiMessage;
            result.setText(bmiMessage);
}}

