package com.example.servicesbookingapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesbookingapp.MainManu.Dashboard;
import com.example.servicesbookingapp.R;

public class Recipt extends AppCompatActivity {

    TextView name, address, phone, comment, service;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);


        name = findViewById(R.id.yourname3);
        address = findViewById(R.id.address3);
        phone = findViewById(R.id.phonenum3);
        comment = findViewById(R.id.comment3);
        service = findViewById(R.id.service3);
        btn = findViewById(R.id.btn3);



        SharedPreferences sharedPreferences = getSharedPreferences("Booking", MODE_PRIVATE);
        String name1 = sharedPreferences.getString("name","");
        String address1 = sharedPreferences.getString("address","");
        String phone1 = sharedPreferences.getString("phone","");
        String service1 = sharedPreferences.getString("service","");
        String comment1 = sharedPreferences.getString("comment","");



        name.setText(name1);
        address.setText(address1);
        phone.setText(phone1);
        service.setText(service1);
        comment.setText(comment1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Recipt.this, Dashboard.class));
                Toast.makeText(Recipt.this, "Good night", Toast.LENGTH_SHORT).show();
            }
        });






    }
}