package com.example.servicesbookingapp.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.servicesbookingapp.Adapters.Bookingadapter;
import com.example.servicesbookingapp.HelperClasses.bookingmodel;
import com.example.servicesbookingapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bookings extends AppCompatActivity {

    RecyclerView recyclerView;
    Bookingadapter bookingadapter;
    ArrayList<bookingmodel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        recyclerView = findViewById(R.id.recyclerviewid);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sharedPreferences = getSharedPreferences("profile", MODE_PRIVATE);
        String phonenum = sharedPreferences.getString("phone","");

        SharedPreferences sharedPreferences2 = getSharedPreferences("Services", MODE_PRIVATE);
        String ser = sharedPreferences2.getString("ser","");

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Users").child(phonenum).child("Booking");

        list = new ArrayList<>();
        bookingadapter = new Bookingadapter(this,list);
        recyclerView.setAdapter(bookingadapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot db:snapshot.getChildren()){

                    bookingmodel bmodel =db.getValue(bookingmodel.class);
                    list.add(bmodel);
                }
                bookingadapter.notifyDataSetChanged();
                Toast.makeText(Bookings.this, "Successful", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Bookings.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}