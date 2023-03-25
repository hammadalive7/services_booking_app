package com.example.servicesbookingapp.User;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.servicesbookingapp.Adapters.Adapter;
import com.example.servicesbookingapp.R;

import java.util.ArrayList;

public class PlumberMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    private GradientDrawable gradient1, gradient2, gradient3,gradient4,gradient5,gradient6,gradient7,gradient8,gradient9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_electrician_menu);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(PlumberMenu.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {


                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();





                        if (position == 0) {
//
                            String sc = "Plumbing Services";
                            editor.putString("ser", sc);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                            String cc = "Water Motor Services";
                            editor.putString("ser", cc);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "Water Tank Service";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 3) {

                            String service = "Kitchen Plumbing Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 4) {

                            String service = "Geyser Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        } if (position == 5) {

                            String service = "Bathroom Plumbing Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(PlumberMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(PlumberMenu.this,SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );

        ArrayList<Model> list= new ArrayList<>();

        list.add(new Model(R.drawable.plumber,"Plumbing Services"));
        list.add(new Model(R.drawable.p2,"Water Motor Plumbing"));
        list.add(new Model(R.drawable.p2,"Water Tank Plumbing"));
        list.add(new Model(R.drawable.p4,"Kitchen Plumbing Or Installation"));
        list.add(new Model(R.drawable.p5,"Geyser Install Or Repair"));
        list.add(new Model(R.drawable.p6,"Bathroom Plumbing Or Installation"));


        Adapter adapter=new Adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}