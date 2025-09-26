package com.example.initproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactActivity extends AppCompatActivity {

    Button btnCallPhone, btnSendSMS, btnCamera, btnBrowser, btnMusic;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCallPhone= findViewById(R.id.btnCallPhone);
        btnSendSMS= findViewById(R.id.btnSendSMS);
        btnCallPhone.setOnClickListener(v -> {
            intent =new Intent(ContactActivity.this,CallPhoneActivity.class);
            startActivity(intent);
        });
        btnSendSMS.setOnClickListener(v -> {
            intent= new Intent(ContactActivity.this, MessageActivity.class);
            startActivity(intent);
        });

        btnCamera= findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(v -> {
            intent = new Intent(ContactActivity.this,CameraActivity.class);
            startActivity(intent);
        });
        btnBrowser= findViewById(R.id.btnBrowser);
        btnBrowser.setOnClickListener(v -> {
            intent = new Intent(ContactActivity.this,BrowserActivity.class);
            startActivity(intent);
        });

        btnMusic = findViewById(R.id.btnMusic);
        btnMusic.setOnClickListener(v -> {
            intent = new Intent(ContactActivity.this, MusicActivity.class);
            startActivity(intent);
        });
    }
}