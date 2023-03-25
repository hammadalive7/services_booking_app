package com.example.servicesbookingapp.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.servicesbookingapp.HelperClasses.Formhelper;
import com.example.servicesbookingapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class submitform extends AppCompatActivity {

    Button sub;
    EditText name, phone, nic, comment, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitform);

        sub = findViewById(R.id.submitbtn);
        name = findViewById(R.id.yourname);
        phone = findViewById(R.id.phonenum1);
        nic = findViewById(R.id.nic);
        comment = findViewById(R.id.comment);
        address = findViewById(R.id.address);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1 = name.getText().toString();
                String phone1 = phone.getText().toString();
                String address1 = address.getText().toString();
                String nic1 = nic.getText().toString();
                String comment1 = comment.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("Services", MODE_PRIVATE);
                String ser = sharedPreferences.getString("ser","");


                Query checkuser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(phone1);

                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            phone.setError(null);



                            FirebaseDatabase database = FirebaseDatabase.getInstance();

                            DatabaseReference reference = database.getReference("Users").child(phone1).child("Booking").push();
                            Formhelper newformDatabase = new Formhelper(name1,phone1,address1,nic1,ser,comment1);

                            reference.setValue(newformDatabase);


                            Toast.makeText(submitform.this, "Form submited", Toast.LENGTH_SHORT).show();

                            SharedPreferences sharedPref = getSharedPreferences("Booking", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();

                            editor.putString("name", name1);
                            editor.putString("phone", phone1);
                            editor.putString("address", address1);
                            editor.putString("comment", comment1);
                            editor.putString("service", ser);

                            editor.apply();



                            startActivity(new Intent(submitform.this, Recipt.class));

                        }
                        else{
                            Toast.makeText(submitform.this, "Please Enter Registered Number!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(submitform.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });










            }
        });




    }
}