package com.example.initproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReceiverMassageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver_massage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //kiểm tra và yêu cầu quyền truy cập nhận và đọc message
        if(ActivityCompat.checkSelfPermission(ReceiverMassageActivity.this,
                Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
                 ActivityCompat.requestPermissions(ReceiverMassageActivity.this,
                         new String[]{Manifest.permission.RECEIVE_SMS,
                                 Manifest.permission.READ_SMS},1);
                 return;
        }
    }
}