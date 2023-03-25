package com.example.servicesbookingapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesbookingapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updatepass extends AppCompatActivity {

    Button update;
    TextInputLayout pass1, pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepass);


        update = findViewById(R.id.newpasswordbtn);
        pass1 = findViewById(R.id.new_password);
        pass2 = findViewById(R.id.confirm_password);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _newpass = pass2.getEditText().getText().toString().trim();
                String _phoneNumber = getIntent().getStringExtra("phoneNo");

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                reference.child(_phoneNumber).child("password").setValue(_newpass);

                startActivity(new Intent(getApplicationContext(), Succmsgofpass.class));
                finish();

            }
        });
    }
}