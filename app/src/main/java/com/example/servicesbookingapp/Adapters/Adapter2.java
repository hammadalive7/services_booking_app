package com.example.servicesbookingapp.Adapters;



import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.User.Model1;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {


    ArrayList<Model1> data1;
    Context context;

    public Adapter2(ArrayList<Model1> data1, Context context) {
        this.data1 = data1;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout3,parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model1 model= data1.get(position);
        holder.imageview.setImageResource(model.getPic());
        holder.imageview1.setImageResource(model.getPic1());
        holder.textview1.setText(model.getTitle());
        if(position  == 0)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 1)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 2)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 3)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 4)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 5)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 6)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 7)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 8)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position==9)
        {
            holder.lyt_content_view2.setBackgroundColor(Color.parseColor("#888b77"));
        }

    }


    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public View lyt_content_view2;
        ImageView imageview;
        ImageView imageview1;
        TextView textview1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            lyt_content_view2=itemView.findViewById(R.id.relative2);
            imageview=itemView.findViewById(R.id.image2);
            imageview1=itemView.findViewById(R.id.image3);
            textview1= itemView.findViewById(R.id.Title2);




        }
    }
}
