package com.example.initproject.ArrayAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.initproject.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> arrayList;
    //tạo constructor để truyền tham số
    public MyArrayAdapter( Activity context, int idLayout, ArrayList<Phone> arrayList) {
        super(context, idLayout,arrayList);
        this.context = context;
        this.idLayout = idLayout;
        this.arrayList = arrayList;
    }
    //gọi hàm getview để tiến hành sắp xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //tạo để chứa layout
        LayoutInflater layoutInflater = context.getLayoutInflater();
        //đặt idlayout lên để tạo thành view
        convertView= layoutInflater.inflate(idLayout,null);

        //Lấy 1 Phần tử trong mảng
        Phone phone = arrayList.get(position);

        //Khai báo và tham chiếu đối tượng
        ImageView imagePhone = convertView.findViewById(R.id.imgPhone);
        imagePhone.setImageResource(phone.getImage());

        TextView textViewPhone = convertView.findViewById(R.id.textViewNamePhone);
        textViewPhone.setText(phone.getName());
        return convertView;

    }
}
