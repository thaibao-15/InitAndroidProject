package com.example.initproject;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CameraActivity extends AppCompatActivity {
    ImageButton btnTakeAPhoto;
    ImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_camera);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imagePhoto = findViewById(R.id.imagePhoto);
        btnTakeAPhoto =findViewById(R.id.btnTakeAPhoto);
        btnTakeAPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(ACTION_IMAGE_CAPTURE);
            // Kiểm tra quyền
            if (ActivityCompat.checkSelfPermission(CameraActivity.this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                // Nếu chưa có quyền thì xin quyền
                ActivityCompat.requestPermissions(CameraActivity.this,
                        new String[]{Manifest.permission.CAMERA}, 1);
                return; // Thoát để chờ user chọn Cho phép / Từ chối
            }
            startActivityForResult(intent,99);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99&& resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imagePhoto.setImageBitmap(photo);
        }
    }
}