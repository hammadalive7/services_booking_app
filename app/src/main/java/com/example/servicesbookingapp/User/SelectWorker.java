package com.example.servicesbookingapp.User;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.servicesbookingapp.Adapters.Adapter2;
import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.admin.submitform;

import java.util.ArrayList;

public class SelectWorker extends AppCompatActivity  {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_worker);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(SelectWorker.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent=new Intent(SelectWorker.this, submitform.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(SelectWorker.this, submitform.class);
                        startActivity(intent);
                    }
                })
        );


        ArrayList<Model1> data1 = new ArrayList<>();
        data1.add(new Model1(R.drawable.person,R.drawable.fivestar, "Haider"));
        data1.add(new Model1(R.drawable.person,R.drawable.fourstar, "Fakhar"));
        data1.add(new Model1(R.drawable.person,R.drawable.threestar, "Ahsan"));
        data1.add(new Model1(R.drawable.person,R.drawable.fourstar, "Rehan"));
        data1.add(new Model1(R.drawable.person,R.drawable.fivestar, "Babar"));
        data1.add(new Model1(R.drawable.person,R.drawable.threestar, "Ali"));
        data1.add(new Model1(R.drawable.person,R.drawable.fourstar, "Ahmad"));
        data1.add(new Model1(R.drawable.person,R.drawable.fivestar, "Asif"));
        data1.add(new Model1(R.drawable.person,R.drawable.fourstar, "Khushdil"));

        Adapter2 adapter2 = new Adapter2(data1, this);
        recyclerView.setAdapter(adapter2);


        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager3);





    }

}