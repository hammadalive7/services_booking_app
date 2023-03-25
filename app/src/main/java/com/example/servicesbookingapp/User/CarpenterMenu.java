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

public class CarpenterMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_electrician_menu);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(CarpenterMenu.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedPref.edit();



                        if (position == 0) {

                            String service = "Wooden Door Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CarpenterMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                            String service = "Wooden Furniture Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CarpenterMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "Carpainter Services";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(CarpenterMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(CarpenterMenu.this,SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );

        ArrayList<Model> list= new ArrayList<>();


        list.add(new Model(R.drawable.door,"Wooden Door Repair"));
        list.add(new Model(R.drawable.chair,"Wooden Furniture Repair"));
        list.add(new Model(R.drawable.tool,"Other Carpenter Services"));


        Adapter adapter=new Adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}