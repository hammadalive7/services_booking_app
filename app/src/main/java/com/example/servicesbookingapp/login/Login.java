package com.example.servicesbookingapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.servicesbookingapp.MainManu.Dashboard;
import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.admin.Profile_Activity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private static final String FILE_NAME = "myFileSP";
    Button createacc, login, passforgot;
    EditText phoneNumber, pass;
    ProgressBar progressbar;
    CheckBox rememberme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        createacc = findViewById(R.id.createacc);
        login = findViewById(R.id.loginbtnn);
        phoneNumber = findViewById(R.id.loginuser);
        pass = findViewById(R.id.loginpassword);
        progressbar = findViewById(R.id.prograssbarlogin);
        passforgot = findViewById(R.id.forgotpasslogin);
        rememberme = findViewById(R.id.rememberme);




        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        passforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Forgetpass.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(!validateFields()){
//                    return;
//                }

                progressbar.setVisibility(View.VISIBLE);


                String _phonenumber = phoneNumber.getText().toString().trim();
                String _pass = pass.getText().toString().trim();


                if(rememberme.isChecked()){
                    storedatausingSP(_phonenumber,_pass);
                }

                String final_phonenumber = _phonenumber;


                Query checkuser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(final_phonenumber);

                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            phoneNumber.setError(null);

                            String systempass = snapshot.child(final_phonenumber).child("password").getValue(String.class);

                            SharedPreferences sharedPref = getSharedPreferences("profile", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("phone", final_phonenumber);
                            editor.apply();



                            if (systempass.equals(_pass)) {
                                pass.setError(null);


                                Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(Login.this, Dashboard.class));

                            }
                            else{
                                progressbar.setVisibility(View.GONE);
                                Toast.makeText(Login.this, "Password does not match", Toast.LENGTH_SHORT).show();


                            }
                        }
                        else{
                            progressbar.setVisibility(View.GONE);
                            Toast.makeText(Login.this, "No such User exist", Toast.LENGTH_SHORT).show();


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progressbar.setVisibility(View.GONE);
                        Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


            }


        });


    }

    private void storedatausingSP(String phonenumber, String pass) {

        SharedPreferences.Editor SP = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        SP.putString("PhoneNumber", phonenumber);
        SP.putString("Password", pass);
        SP.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String phone = sharedPreferences.getString("PhoneNumber","");
        String password = sharedPreferences.getString("Password","");

        phoneNumber.setText(phone);
        pass.setText(password);


    }

}