package com.example.servicesbookingapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesbookingapp.R;

public class Succmsgofpass extends AppCompatActivity {

    Button wapis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succmsgofpass);

        wapis = findViewById(R.id.successbtn);

        wapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Succmsgofpass.this, Login.class));
            }
        });
    }
}