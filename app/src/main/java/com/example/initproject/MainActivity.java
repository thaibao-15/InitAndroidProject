package com.example.initproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editTextC = findViewById(R.id.editTextC);
        EditText editTextF = findViewById(R.id.editTextF);
        Button convertToF = findViewById(R.id.convertToF);
        Button convertToC = findViewById(R.id.convertToC);
        Button btnKQ = findViewById(R.id.btnKQ);

        convertToF.setOnClickListener(v -> {
            editTextF.setText("");
            double celsius = Double.parseDouble(editTextC.getText().toString());
            double fahrenheit = (celsius * 9 / 5) + 32;
            editTextF.setText(String.valueOf(fahrenheit));
        });
        convertToC.setOnClickListener(v -> {
            editTextC.setText("");
            double fahrenheit = Double.parseDouble(editTextF.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;
            editTextC.setText(String.valueOf(celsius));
        });


    }
    }
