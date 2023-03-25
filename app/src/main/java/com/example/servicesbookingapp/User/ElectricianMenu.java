package com.example.servicesbookingapp.User;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.Adapters.Adapter;

import java.util.ArrayList;

public class ElectricianMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_electrician_menu);
        recyclerView=findViewById(R.id.recyclerview);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ElectricianMenu.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();





                        if (position == 0) {
//
                            String sc = "UPS Install and Repair";
                            editor.putString("ser", sc);
                            editor.apply();


                            Intent intent = new Intent(ElectricianMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                            String cc = "Lightning Install and Repair";
                            editor.putString("ser", cc);
                            editor.apply();


                            Intent intent = new Intent(ElectricianMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "Electrical appliences Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(ElectricianMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(ElectricianMenu.this,SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );

        ArrayList<Model> list= new ArrayList<>();

        list.add(new Model(R.drawable.ups,"UPS Install And Repair"));
        list.add(new Model(R.drawable.e3,"Lightning Install And Repair"));
        list.add(new Model(R.drawable.e10,"Other Electrical Services"));


        Adapter adapter=new Adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}