package com.example.servicesbookingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesbookingapp.HelperClasses.bookingmodel;
import com.example.servicesbookingapp.R;

import java.util.ArrayList;

public class Bookingadapter extends RecyclerView.Adapter<Bookingadapter.MyViewHolder> {

    Context context;
    ArrayList<bookingmodel> list;

    public Bookingadapter(Context context, ArrayList<bookingmodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclermodel,parent,false);

        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        bookingmodel bookingmodel = list.get(position);
        holder.name.setText(bookingmodel.getName());
        holder.servie.setText(bookingmodel.getService());
        holder.address.setText(bookingmodel.getAddress());
        holder.phone.setText(bookingmodel.getPhone());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
               TextView name, servie, address, phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.nameid);
            servie = itemView.findViewById(R.id.serid);
            address = itemView.findViewById(R.id.addid);
            phone = itemView.findViewById(R.id.mailid);
        }
        }
    }


