package com.example.peretz.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DishesList {
    @SerializedName("dishes")
    @Expose
    public ArrayList<Dish> dishes = new ArrayList<>();

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes (ArrayList<Dish> dishes){
        this.dishes = dishes;
    }


}