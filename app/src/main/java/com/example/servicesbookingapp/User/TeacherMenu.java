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

public class TeacherMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    private GradientDrawable gradient1, gradient2, gradient3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_electrician_menu);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(TeacherMenu.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();





                        if (position == 0) {
//
                            String sc = "Math Teacher";
                            editor.putString("ser", sc);
                            editor.apply();


                            Intent intent = new Intent(TeacherMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                            String cc = "Science Teacher";
                            editor.putString("ser", cc);
                            editor.apply();


                            Intent intent = new Intent(TeacherMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "English Teacher";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(TeacherMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }
                     if (position == 3) {

                            String service = "Mobile Computing Teacher";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(TeacherMenu.this, SelectWorker.class);
                            startActivity(intent);


                        }


                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(TeacherMenu.this,SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );

        ArrayList<Model> list= new ArrayList<>();

        list.add(new Model(R.drawable.t1,"Math Teacher"));
        list.add(new Model(R.drawable.t2,"Science Teacher"));
        list.add(new Model(R.drawable.t3,"English Teacher"));
        list.add(new Model(R.drawable.t4,"Mobile Computing Teacher"));


        Adapter adapter=new Adapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}