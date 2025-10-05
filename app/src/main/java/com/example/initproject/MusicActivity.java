package com.example.initproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MusicActivity extends AppCompatActivity {
    ImageButton btnPlay, btnStop;
    Boolean flag;


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
        btnPlay = findViewById(R.id.btnPlayMusic2);
        btnStop = findViewById(R.id.btnPauseMusic);



        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(MusicActivity.this, MyService.class);
            startService(intent);
//            if(flag==true){
//                btnPlay.setImageResource(R.drawable.isplay);
//                flag= false;
//            }else {
//                btnPlay.setImageResource(R.drawable.ispause);
//            }
        });
        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MusicActivity.this, MyService.class);
            stopService(intent);
        });
    }
}