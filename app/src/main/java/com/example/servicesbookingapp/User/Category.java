package com.example.servicesbookingapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.servicesbookingapp.Adapters.Adapter1;
import com.example.servicesbookingapp.R;

import java.util.ArrayList;

public class Category extends AppCompatActivity  {
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    Adapter1 adapter1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.category);
        recyclerView = findViewById(R.id.recyclerview);
        relativeLayout = findViewById(R.id.relative);


        ArrayList<Model> list = new ArrayList<>();

        list.add(new Model(R.drawable.election, "Electrical Services"));
        list.add(new Model(R.drawable.plumber, "Plumbing Services"));
        list.add(new Model(R.drawable.painter, "Paint Services"));
        list.add(new Model(R.drawable.cleaner, "Cleaning Services"));
        list.add(new Model(R.drawable.pester, "Pest Control Services"));
        list.add(new Model(R.drawable.homeapplince, "Home Appliance Repair"));
        list.add(new Model(R.drawable.cctv, "CCTV Services"));
        list.add(new Model(R.drawable.teacher, "Teaching Services"));
        list.add(new Model(R.drawable.carpanter, "Carpenter Services"));

        Adapter1 adapter = new Adapter1(list, this);
        recyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {

                    case 0:
                        Intent intent = new Intent(Category.this, ElectricianMenu.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(Category.this, PlumberMenu.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(Category.this, PainterMenu.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Category.this, CleanerMenu.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(Category.this, PestMenu.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(Category.this, HomeApplianceMenu.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(Category.this, CctvMenu.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(Category.this, TeacherMenu.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(Category.this, CarpenterMenu.class);
                        startActivity(intent8);
                        break;


                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));




    }
  //  @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu, menu);
////        MenuItem item=menu.findItem(R.id.search);
//
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String NewText) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String NewText) {
//                Filter filter;
//                if(adapter1 != null){
//                     filter = adapter1.getFilter();
//                    if (filter != null) {
//                        filter.filter(NewText);
//
//                        return true;
//                }
//
//
//                }
//
//                return false;
//            }
//
//
//
//
//
//
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
}