package com.example.event;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.event.adapters.CategoryAdapter;
import com.example.event.adapters.EventAdapter;
import com.example.event.api.ApiService;
import com.example.event.models.Category;
import com.example.event.models.Event;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import com.example.event.api.ApiEndpoint; // Make sure you have this import

public class MainActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private RecyclerView trendingEventsListView;
    private CategoryAdapter categoryAdapter;
    private EventAdapter eventAdapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiService.getInstance();

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        trendingEventsListView = findViewById(R.id.trendingEventsRecyclerView);

        fetchAndDisplayCategories();
        fetchAndDisplayTrendingEvents();
    }

    private void fetchAndDisplayCategories() {
        Call<List<Category>> categoryCall = apiService.getApiEndpoint().getCategories();
        categoryCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    List<Category> categories = response.body();
                    setupCategoryRecyclerView(categories);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                // Handle error
            }
        });
    }

    private void setupCategoryRecyclerView(List<Category> categories) {
        categoryAdapter = new CategoryAdapter(categories);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void fetchAndDisplayTrendingEvents() {
        Call<List<Event>> eventCall = apiService.getApiEndpoint().getEvents();
        eventCall.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    List<Event> trendingEvents = response.body();
                    setupTrendingEventsListView(trendingEvents);
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                // Handle error
            }
        });
    }

    private void setupTrendingEventsListView(List<Event> trendingEvents) {
//        eventAdapter = new EventAdapter(trendingEvents);
        eventAdapter = new EventAdapter(this, trendingEvents);

        trendingEventsListView.setLayoutManager(new LinearLayoutManager(this));
        trendingEventsListView.setAdapter(eventAdapter);
    }
}




