package com.example.peretz.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.peretz.activity.SecondActivity;
import com.example.peretz.model.Dish;
import com.example.peretz.R;
import com.example.peretz.model.DishesList;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.DishViewHolder> {
    private ArrayList<Dish> dishes;
    Context context;
    int mCount = 0;
    public Adapter(Context context, ArrayList<Dish> dishes){
        this.dishes = dishes;
        this.context =context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDishes( ArrayList<Dish> dishes)
    {this.dishes = dishes;
    notifyDataSetChanged();
    }


    @NonNull
    @Override
    public Adapter.DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,
                parent,false);
        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.DishViewHolder holder, int position)  {
        Dish dish = dishes.get(position);
        holder.name.setText(dish.getName());
        holder.dishDescription.setText(dish.getDescription());
        holder.dishPrice.setText(dish.getPrice());
        Glide.with(context).load(dish.getImage()).apply(RequestOptions.centerCropTransform())
                .into(holder.dishPhoto);

        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.dishAmount.setText(++mCount);
            }
        });
        holder.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.dishAmount.setText(mCount--);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder{
        TextView name, dishPrice, dishDescription, dishNews, dishAmount;
        ImageView dishPhoto;
        Button buttonPlus, buttonMinus;
        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            dishPrice = itemView.findViewById(R.id.price);
            dishNews = itemView.findViewById(R.id.news);
            dishDescription= itemView.findViewById(R.id.description);
            dishPhoto = itemView.findViewById(R.id.imageView);
            dishAmount = itemView.findViewById(R.id.amount);
            buttonPlus = itemView.findViewById(R.id.plus);
            buttonMinus = itemView.findViewById(R.id.minus);

        }
    }
}


