package com.example.peretz.api;

import com.example.peretz.model.Dish;
import com.example.peretz.model.DishesList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v2/products")
    Call<ArrayList<Dish>> getDishesToMenu(
            @Query("category") String category,
            @Query("key") String key);

}
