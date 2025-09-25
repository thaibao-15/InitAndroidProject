package com.example.initproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessageActivity extends AppCompatActivity {
    EditText edtMessage;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMessage= findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            Intent messageIntent= new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtMessage.getText().toString()));
            startActivity(messageIntent);
        });
    }
}