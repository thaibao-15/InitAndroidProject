package com.example.initproject;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtKQ;
    Button btnContact;
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
        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);

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


        Button btnopen = findViewById(R.id.btnopen);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ChildActivity.class);
                startActivity(intent);
            }
        });

        btnKQ.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ChildActivity.class);
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            Bundle bundle =new Bundle();
            bundle.putInt("numberA",a);
            bundle.putInt("numberB",b);

            intent.putExtra("mypackage",bundle);
            startActivity(intent);
        });
        //transfer và nhận lại
        EditText edtg =findViewById(R.id.edtG);

        Button btnGH =findViewById(R.id.btnGH);

        btnGH.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this,ChildActivity.class);
            int g = Integer.parseInt(edtg.getText().toString());

            myIntent.putExtra("sog",g);
            startActivityForResult(myIntent,99);
        });

        btnContact =findViewById(R.id.btnContact);
        btnContact.setOnClickListener(v -> {
            Intent intent =new Intent(MainActivity.this,ContactActivity.class);
            startActivity(intent);

        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        edtKQ =findViewById(R.id.edtH);
        if(requestCode==99 && resultCode==33){
            int kq =data.getIntExtra("kq",0);
            edtKQ.setText(kq+"");
        }else if(requestCode==99 && resultCode==34){
            int kq =data.getIntExtra("kq",0);
            edtKQ.setText(kq+"");
        }
    }
}
