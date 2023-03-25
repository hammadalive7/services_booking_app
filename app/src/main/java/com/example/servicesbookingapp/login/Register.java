package com.example.servicesbookingapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesbookingapp.Databases.UserDatabase;
import com.example.servicesbookingapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    DatabaseReference reference;


    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;

    TextInputLayout fullname, username, email, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        next = findViewById(R.id.signupnextbutton);
        login = findViewById(R.id.signuploginbutton);
        titleText = findViewById(R.id.signup_title_text);

        fullname = findViewById(R.id.signup_fullname);
        email = findViewById(R.id.signup_email);
        username = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validateFullName() | !validatePassword() | !validateUsername() | !validateEmail()){
                    return;
                }


                String fullname2 = fullname.getEditText().getText().toString();
                String email2 = email.getEditText().getText().toString();
                String username2 = username.getEditText().getText().toString();
                String password2 = password.getEditText().getText().toString();



                Intent intent = new Intent(getApplicationContext(), SecSignUp.class);

                intent.putExtra("Fullname", fullname2);
                intent.putExtra("Email", email2);
                intent.putExtra("Username", username2);
                intent.putExtra("Password", password2);


                startActivity(intent);

            }
        });


    }


  //  public void callNext(View view) {


  //  }


    public void callLogin(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }


    private boolean validateFullName(){
        String val = fullname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Field can not be Empty");
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too large!");
            return false;

        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        Pattern PASSWORD_PATTERN
                = Pattern.compile(
                "[a-zA-Z0-9\\!\\@\\#\\$]{3,24}");

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        }
        if(val.length()<3){
            password.setError("Password should be greater then 3 no.");
            return false;

        }

        return !TextUtils.isEmpty(val) && PASSWORD_PATTERN.matcher(val).matches();
    }




}