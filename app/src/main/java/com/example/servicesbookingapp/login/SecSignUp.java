package com.example.servicesbookingapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.servicesbookingapp.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SecSignUp extends AppCompatActivity {

    Button login, register;
    RadioButton radiogander;
    RadioGroup radioGroup;
    EditText phoneNumber;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_sign_up);



        login = findViewById(R.id.signup_login_button);
        register = findViewById(R.id.signup_reg_button);
        radioGroup = findViewById(R.id.radio_group);
        login = findViewById(R.id.signup_login_button);
        phoneNumber = findViewById(R.id.inputmobile);
        progressBar = findViewById(R.id.prograssbar);
        radiogander = findViewById(radioGroup.getCheckedRadioButtonId());






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validateGender() | !validatePhoneNumber()){
                    return;
                }




                if (phoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SecSignUp.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }


             //   String gender = String.valueOf(radiogander.getText());
                String Fullname = getIntent().getStringExtra("Fullname");
                String Username = getIntent().getStringExtra("Username");
                String Email = getIntent().getStringExtra("Email");
                String Password = getIntent().getStringExtra("Password");



//
//                Intent i = new Intent(SecSignUp.this, Login.class);
//                startActivity(i);



                progressBar.setVisibility(View.VISIBLE);
                register.setVisibility(View.INVISIBLE);



                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+92" + phoneNumber.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        SecSignUp.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                            }



                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                                Toast.makeText(SecSignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationid, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken){

                                progressBar.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);

                                Intent intent = new Intent(getApplicationContext(), OTP.class);
                                intent.putExtra("mobile", phoneNumber.getText().toString());
                                intent.putExtra("verificationid", verificationid);
                                intent.putExtra("Fullname", Fullname);
                                intent.putExtra("Email", Email);
                                intent.putExtra("Username", Username);
                                intent.putExtra("Password", Password);

                                startActivity(intent);

                            }
                        }

                );



            }
        });


        // OTP /////////////





    }

//    public void callOTP(View view) {
//
//    }




    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getText().toString().trim();
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;

        } else {
            phoneNumber.setError(null);
            return true;
        }
    }

}