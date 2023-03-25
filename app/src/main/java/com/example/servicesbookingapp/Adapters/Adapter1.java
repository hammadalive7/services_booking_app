package com.example.servicesbookingapp.Adapters;



import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesbookingapp.R;
import com.example.servicesbookingapp.User.Model;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder> implements Filterable {


    ArrayList<Model> data;
    ArrayList<Model>backup;
    Context context;




    public Adapter1(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
        backup=new ArrayList<>(data);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout2,parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model model= data.get(position);
        holder.imageview.setImageResource(model.getPic());
        holder.textview1.setText(model.getTitle());
        if(position  == 0)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 1)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 2)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 3)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 4)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 5)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position  == 6)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00ffce"));
        }
        if(position  == 7)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#00d2ff"));
        }
        if(position  == 8)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#f498ad"));
        }
        if(position==9)
        {
            holder.lyt_content_view.setBackgroundColor(Color.parseColor("#888b77"));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return FilterUser;
    }

    private Filter FilterUser=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String SearchText=charSequence.toString().toLowerCase();
            ArrayList<Model> tempList=new ArrayList<>();
            if(SearchText.length()==0 || SearchText.isEmpty()){

                tempList.addAll(backup);
            }
            else
            {
                for(Model item:backup){
                    if(item.getTitle().toLowerCase().contains(SearchText.toString().toLowerCase())){
                        tempList.add(item);
                    }

                }
            }

            FilterResults filterResults=new FilterResults();
            filterResults.values=tempList;
            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            data.clear();
            data.addAll((ArrayList<Model>)filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{


        public View lyt_content_view;
        ImageView imageview;
        TextView textview1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            lyt_content_view=itemView.findViewById(R.id.relative);
            imageview=itemView.findViewById(R.id.image1);
            textview1= itemView.findViewById(R.id.Title1);




        }
    }
}
