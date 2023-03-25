package com.example.servicesbookingapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesbookingapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Profile_Activity extends AppCompatActivity {

    private TextView userTxtView, nameTxtView;
    private TextView emailTxtView, phoneTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userTxtView = findViewById(R.id.user_textview);
        nameTxtView = findViewById(R.id.name_textview9);
        emailTxtView = findViewById(R.id.email_textview);
        phoneTxtView = findViewById(R.id.phone_textview);


        SharedPreferences sharedPreferences = getSharedPreferences("profile", MODE_PRIVATE);
        String phonenum = sharedPreferences.getString("phone","");







        Query checkuser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(phonenum);

        // Read from the database
        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    String fname = dataSnapshot.child(phonenum).child("fullname").getValue(String.class);
                    String mail = dataSnapshot.child(phonenum).child("email").getValue(String.class);
                    String username = dataSnapshot.child(phonenum).child("username").getValue(String.class);
                    String phone = dataSnapshot.child(phonenum).child("phoneNo").getValue(String.class);

                    nameTxtView.setText(username);
                    emailTxtView.setText(mail);
                    userTxtView.setText(fname);
                    phoneTxtView.setText(phone);

                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(Profile_Activity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }


}



