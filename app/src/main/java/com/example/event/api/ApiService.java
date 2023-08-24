package com.example.event.api;

import com.example.event.models.Category;
import com.example.event.models.Event;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL = "https://event.activeapp.in/"; // Replace with your actual base URL

    private static ApiService instance;
    private Retrofit retrofit;

    private ApiService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    public ApiEndpoint getApiEndpoint() {
        return retrofit.create(ApiEndpoint.class);
    }


}


