package com.example.initproject.ArrayAdapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.initproject.R;

import java.util.ArrayList;

public class ListViewCustomActivity extends AppCompatActivity {
    int[] image ={R.drawable.anhgai1,R.drawable.anhgai2,R.drawable.anhgai3};
    String[] name = {"gai", "gay", "Lgpt"};
    MyArrayAdapter myArrayAdapter;
    ListView listView;
    ArrayList<Phone> arrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_custom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listViewCustom);
        arrayList = new ArrayList<>();
        for(int i =0;i<image.length; i++){

            arrayList.add(new Phone(image[i],name[i]));
        }

        myArrayAdapter= new MyArrayAdapter(ListViewCustomActivity.this,R.layout.layout_item,arrayList);
        listView.setAdapter(myArrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListViewCustomActivity.this,SubActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("image",image[position]);
            bundle.putString("name",name[position]);
            intent.putExtra("bundle",bundle);
            startActivity(intent);
        });
    }
}