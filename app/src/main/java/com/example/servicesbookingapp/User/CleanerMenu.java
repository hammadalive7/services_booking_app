package com.example.servicesbookingapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.servicesbookingapp.Adapters.Adapter;
import com.example.servicesbookingapp.R;

import java.util.ArrayList;

public class CleanerMenu extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_electrician_menu);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(CleanerMenu.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {


                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();





                        if (position == 0) {
//
                             String sc = "Sofa Cleaning";
                            editor.putString("ser", sc);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                             String cc = "Carpet Cleaning";
                             editor.putString("ser", cc);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "Deep Cleaning Service";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 3) {

                            String service = "Mattress Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 5) {

                            String service = "Curtain Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 6) {

                            String service = "Commercial Cleaning";
                            editor.putString("ser", service);
                            editor.apply();

                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 7) {

                            String service = "Window Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 8) {

                            String service = "Floor Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 9) {

                            String service = "Kitchen Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 10) {

                            String service = "Glass Cleaning";
                            editor.putString("ser", service);
                            editor.apply();

                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 11) {

                            String service = "Bathroom Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Intent intent = new Intent(CleanerMenu.this, SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );

        ArrayList<Model> list = new ArrayList<>();


        list.add(new Model(R.drawable.c1, "Sofa Cleaning"));
        list.add(new Model(R.drawable.c2, "Carpet Cleaning"));
        list.add(new Model(R.drawable.c3, "Deep Cleaning Service"));
        list.add(new Model(R.drawable.c4, "Mattress Cleaning"));
        list.add(new Model(R.drawable.c5, "Curtain Cleaning"));
        list.add(new Model(R.drawable.c3, "Commercial Cleaning"));
        list.add(new Model(R.drawable.c5, "Window Cleaning"));
        list.add(new Model(R.drawable.c7, "Floor Cleaning"));
        list.add(new Model(R.drawable.p4, "Kitchen Cleaning"));
        list.add(new Model(R.drawable.c5, "Glass Cleaning"));
        list.add(new Model(R.drawable.c7, "Bathroom Cleaning"));


        Adapter adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}