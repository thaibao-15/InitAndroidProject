package com.example.initproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MusicActivity extends AppCompatActivity {
    ImageButton btnPlay, btnPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnPlay = findViewById(R.id.btnPlayMusic);
        btnPause = findViewById(R.id.btnPauseMusic);
        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MusicActivity.this, MyService.class);
            startService(intent);
        });
        btnPause.setOnClickListener(v -> {
            Intent intent = new Intent(MusicActivity.this, MyService.class);
            stopService(intent);
        });
    }
}