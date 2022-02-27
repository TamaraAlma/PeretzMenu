package com.example.peretz.activity;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peretz.adapter.Adapter;
import com.example.peretz.model.Dish;
import com.example.peretz.R;
import com.example.peretz.api.RetroClient;
import com.example.peretz.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    Context context;
    ArrayList<Dish> dishes;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),
                llm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        dishes = new ArrayList<>();
        Adapter adapter = new Adapter(this, dishes);
        rv.setAdapter(adapter);


        ApiService api = RetroClient.getClient().create(ApiService.class);
        Call<ArrayList<Dish>> call = api.getDishesToMenu("106", "47be9031474183ea92958d5" +
                "e255d888e47bdad44afd5d7b7201d0eb572be5278");
        call.enqueue(new Callback<ArrayList<Dish>>() {
            @Override
            public void onResponse(Call<ArrayList<Dish>> call, Response<ArrayList<Dish>> response) {
                dishes = response.body();
                Log.d("TAG", "Response = " + dishes);
                adapter.setDishes(dishes);

            }

            @Override
            public void onFailure(Call<ArrayList<Dish>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.searchable, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_bar) {
        }
        return super.onOptionsItemSelected(item);
    }





}


