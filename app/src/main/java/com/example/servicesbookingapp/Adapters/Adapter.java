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
import com.example.servicesbookingapp.User.Model;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    ArrayList<Model> list;
    Context context;

    public Adapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model model= list.get(position);
        holder.imageview.setImageResource(model.getPic());
        holder.textview1.setText(model.getTitle());
        if(position  == 0)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 1)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 2)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 3)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 4)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 5)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 6)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 7)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 8)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position==9)
        {
            holder.lyt_content_view1.setBackgroundColor(Color.parseColor("#888b77"));
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public View lyt_content_view1;
        ImageView imageview;
        TextView textview1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            lyt_content_view1=itemView.findViewById(R.id.relative1);
            imageview=itemView.findViewById(R.id.image2);
            textview1= itemView.findViewById(R.id.Title2);




        }
    }
}
