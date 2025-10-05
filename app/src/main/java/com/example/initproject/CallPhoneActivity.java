package com.example.initproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CallPhoneActivity extends AppCompatActivity {
    EditText textPhoneNumber;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call_phone);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textPhoneNumber= findViewById(R.id.textPhoneNumber);
        btnCall= findViewById(R.id.btnCall);

        btnCall.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel"+ textPhoneNumber.getText().toString()));
            // Kiểm tra quyền
            if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                // Nếu chưa có quyền thì xin quyền
                ActivityCompat.requestPermissions(CallPhoneActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
                return; // Thoát để chờ user chọn Cho phép / Từ chối
            }
            startActivity(myIntent);
        });
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Người dùng cho phép -> có thể gọi lại chức năng gọi điện
//                String phone = textPhoneNumber.getText().toString();
//                Intent myIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
//                startActivity(myIntent);
//            } else {
//                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

}