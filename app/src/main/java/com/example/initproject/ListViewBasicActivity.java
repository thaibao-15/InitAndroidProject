package com.example.initproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewBasicActivity extends AppCompatActivity {
    TextView textViewDT;
    ListView listViewDT;
    String arrayDT[] ={"iphone 11","iphone 12"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_basic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewDT =findViewById(R.id.textViewDT);
        listViewDT = findViewById(R.id.ListViewDT);

        arrayAdapter = new ArrayAdapter<>(ListViewBasicActivity.this, android.R.layout.simple_list_item_1,arrayDT);
        listViewDT.setAdapter(arrayAdapter);


        listViewDT.setOnItemClickListener((parent, view, position, id) -> {
            textViewDT.setText("vi tri "+ position+ "la "+ arrayDT[position] );
        });

    }
}