package com.example.servicesbookingapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.servicesbookingapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Forgetpass extends AppCompatActivity {

    private EditText phonenum;
    private Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        nextbtn = findViewById(R.id.forget_password_next_btn);
        phonenum = findViewById(R.id.forgetpassword_phone_number);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String _phonenum = phonenum.getText().toString().trim();
                String finalphonenumber = _phonenum;

                Query checkuser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(finalphonenumber);

                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        if (snapshot.exists()) {
                            phonenum.setError(null);

                            Intent i = new Intent(getApplicationContext(), updatepass.class);
                            i.putExtra("phoneNo",finalphonenumber);
                            startActivity(i);
                            finish();

                        }else{
                            phonenum.setError("No such user exist!");
                            phonenum.requestFocus();
                        }


                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }
}