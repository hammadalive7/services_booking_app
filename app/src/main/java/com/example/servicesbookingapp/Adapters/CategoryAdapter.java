package com.example.servicesbookingapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesbookingapp.HelperClasses.Categoryhelperclass;
import com.example.servicesbookingapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<Categoryhelperclass> categorylocater;


    public CategoryAdapter(ArrayList<Categoryhelperclass> categorylocater) {
        this.categorylocater = categorylocater;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_catagories, parent, false);
        CategoryViewHolder cvh = new CategoryViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Categoryhelperclass helperClass = categorylocater.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getCatagory());
        holder.relativeLayout.setBackground(helperClass.getGradient());

    }

    @Override
    public int getItemCount() {
        return categorylocater.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categoryimage);
            textView = itemView.findViewById(R.id.categoryname);

        }
    }

}
