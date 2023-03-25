package com.example.servicesbookingapp.MainManu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.servicesbookingapp.Adapters.CategoryAdapter;
import com.example.servicesbookingapp.Common.MapsActivity;
import com.example.servicesbookingapp.HelperClasses.Categoryhelperclass;
import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.User.CarpenterMenu;
import com.example.servicesbookingapp.User.Category;
import com.example.servicesbookingapp.User.CctvMenu;
import com.example.servicesbookingapp.User.CleanerMenu;
import com.example.servicesbookingapp.User.ElectricianMenu;
import com.example.servicesbookingapp.User.RecyclerItemClickListener;
import com.example.servicesbookingapp.User.SelectWorker;
import com.example.servicesbookingapp.User.TeacherMenu;
import com.example.servicesbookingapp.User.HomeApplianceMenu;
import com.example.servicesbookingapp.User.PainterMenu;
import com.example.servicesbookingapp.User.PestMenu;
import com.example.servicesbookingapp.User.PlumberMenu;
import com.example.servicesbookingapp.admin.Bookings;
import com.example.servicesbookingapp.admin.Profile_Activity;
import com.example.servicesbookingapp.admin.aboutUs;
import com.example.servicesbookingapp.login.Login;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewFlipper viewFlipper;
    RecyclerView catagoryrecycler;
    ImageView menuicon, logout;
    ImageView Ele, Tec, paint, pest, carp, plum, clean, cctv, homeser;


    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    //Drawer Menu
    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);


        //Services Booking
        Ele = findViewById(R.id.Electionimg);
        Tec = findViewById(R.id.teacherimg);
        paint = findViewById(R.id.Painterimg);
        pest = findViewById(R.id.pesterimg);
        plum = findViewById(R.id.plumberimg);
        cctv = findViewById(R.id.cctcimg);
        homeser = findViewById(R.id.homeserimg);
        clean = findViewById(R.id.cleanerimg);
        carp = findViewById(R.id.carpanterimg);
        logout = findViewById(R.id.logout2);
        catagoryrecycler = findViewById(R.id.categories_recycler);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Login.class));
            }
        });

        Ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, ElectricianMenu.class));
            }
        });
        Tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, TeacherMenu.class));
            }
        });
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, PainterMenu.class));
            }
        });
        cctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, CctvMenu.class));
            }
        });
        plum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, PlumberMenu.class));
            }
        });
        pest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, PestMenu.class));
            }
        });
        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, CarpenterMenu.class));
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, CleanerMenu.class));
            }
        });
        homeser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, HomeApplianceMenu.class));
            }
        });


        ///Recycler On click listner


        catagoryrecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(Dashboard.this, catagoryrecycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        SharedPreferences sharedPref = getSharedPreferences("Services", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();



                        if (position == 0) {
//
                            String sc = "AC Install and Repair";
                            editor.putString("ser", sc);
                            editor.apply();


                            Intent intent = new Intent(Dashboard.this, SelectWorker.class);
                            startActivity(intent);


                        }


                        if (position == 1) {

                            String cc = "Kitchen Plumbing Service";
                            editor.putString("ser", cc);
                            editor.apply();


                            Intent intent = new Intent(Dashboard.this, SelectWorker.class);
                            startActivity(intent);


                        }
                        if (position == 2) {

                            String service = "House Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(Dashboard.this, SelectWorker.class);
                            startActivity(intent);


                        }if (position == 3) {

                            String service = "Floor Cleaning";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(Dashboard.this, SelectWorker.class);
                            startActivity(intent);

                        }if (position == 4) {

                            String service = "Wooden Furniture Repair";
                            editor.putString("ser", service);
                            editor.apply();


                            Intent intent = new Intent(Dashboard.this, SelectWorker.class);
                            startActivity(intent);


                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent=new Intent(Dashboard.this,SelectWorker.class);
                        startActivity(intent);
                    }
                })
        );


        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menus);
        content = findViewById(R.id.content);

        naviagtionDrawer();


        // Recycler Code --------------------------------------------------------------------
        catagoryrecycler = findViewById(R.id.categories_recycler);
        CatagoryRecycler();


        // SLider code -----------------------------------------------------------------------
        viewFlipper = findViewById(R.id.viewflipper);
        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};

        for (int i = 0; i < images.length; i++) {
            Imageslider(images[i]);
        }

    }

    ////////////CatagoryRecycler Function//////////////////
    private void CatagoryRecycler() {


        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<Categoryhelperclass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new Categoryhelperclass(gradient1, R.drawable.ac_rep, "AC Repair"));
        categoriesHelperClasses.add(new Categoryhelperclass(gradient2, R.drawable.kitchenplumbing, "Kitchen Plumbing"));
        categoriesHelperClasses.add(new Categoryhelperclass(gradient3, R.drawable.painter, "House Paint"));
        categoriesHelperClasses.add(new Categoryhelperclass(gradient4, R.drawable.cleaner, "Floor Cleaning"));
        categoriesHelperClasses.add(new Categoryhelperclass(gradient1, R.drawable.wf, "Wooden Furniture "));

        catagoryrecycler.setHasFixedSize(true);
        adapter = new CategoryAdapter(categoriesHelperClasses);
        catagoryrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        catagoryrecycler.setAdapter(adapter);


    }

    ///////////// Slider Function ///////////////////
    public void Imageslider(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000); //4sec
        viewFlipper.setAutoStart(true);

        //slider animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    private void naviagtionDrawer(){

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(Color.LTGRAY);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                content.setScaleX(offsetScale);
                content.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = content.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                content.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case R.id.nav_home: {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                break;
            }
            case R.id.nav_login: {
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;

            }
            case R.id.nav_logout: {
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;

            }
            case R.id.nav_profile: {
                startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
                break;

            }
            case R.id.nav_all_categories: {
                startActivity(new Intent(getApplicationContext(), Category.class));
                break;

            }
            case R.id.nav_about: {
                startActivity(new Intent(getApplicationContext(), aboutUs.class));
                break;

            }
            case R.id.nav_HomeServices: {
                startActivity(new Intent(getApplicationContext(), HomeApplianceMenu.class));
                break;

            }
            case R.id.nav_education: {
                startActivity(new Intent(getApplicationContext(), TeacherMenu.class));
                break;

            }
            case R.id.nav_Plumber: {
                startActivity(new Intent(getApplicationContext(), PlumberMenu.class));
                break;

            }
            case R.id.Electrician: {
                startActivity(new Intent(getApplicationContext(), ElectricianMenu.class));
                break;

            }
            case R.id.nav_all_booking: {
                startActivity(new Intent(getApplicationContext(), Bookings.class));
                break;

            }case R.id.nav_contect: {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                break;

            }


        }

        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }

}