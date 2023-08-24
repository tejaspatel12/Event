package com.example.event.api;

import com.example.event.models.Category;
import com.example.event.models.Event;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("get_categories.php") // Replace with your actual endpoint path
    Call<List<Category>> getCategories();


    @GET("get_events.php")
    Call<List<Event>> getEvents();
}

