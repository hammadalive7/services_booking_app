package com.example.servicesbookingapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesbookingapp.Databases.UserDatabase;
import com.example.servicesbookingapp.R;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {

    Button Verify;
    private EditText input1,input2,input3,input4,input5,input6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        TextView textmobile = findViewById(R.id.textmobile);

        textmobile.setText(String.format(
                "+92-%s",getIntent().getStringExtra("mobile")
        ));

        input1 = findViewById(R.id.inputcode1);
        input2 = findViewById(R.id.inputcode2);
        input3 = findViewById(R.id.inputcode3);
        input4 = findViewById(R.id.inputcode4);
        input5 = findViewById(R.id.inputcode5);
        input6 = findViewById(R.id.inputcode6);
        Verify = findViewById(R.id.verifycode);

        setupOTPinputs();

        Verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Phone = getIntent().getStringExtra("mobile");
                String Fullname = getIntent().getStringExtra("Fullname");
                String Username = getIntent().getStringExtra("Username");
                String Email = getIntent().getStringExtra("Email");
                String Password = getIntent().getStringExtra("Password");



                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Users");



                UserDatabase newuserDatabase = new UserDatabase(Fullname,Username,Email,Password,Phone);

                reference.child(Phone).setValue(newuserDatabase);


                Toast.makeText(OTP.this, "Data Stored", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(OTP.this, Login.class));


            }
        });

    }

    private void setupOTPinputs(){
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().trim().isEmpty()){
                    input2.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().trim().isEmpty()){
                    input3.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().trim().isEmpty()){
                    input4.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().trim().isEmpty()){
                    input5.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!charSequence.toString().trim().isEmpty()){
                    input6.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


}