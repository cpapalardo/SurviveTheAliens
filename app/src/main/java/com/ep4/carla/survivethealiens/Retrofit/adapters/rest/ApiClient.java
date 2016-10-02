package com.ep4.carla.survivethealiens.Retrofit.adapters.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carla on 30/09/2016.
 */

public class ApiClient {
    private static APIPlug REST_CLIENT;
    private static final String API_URL = "http://survivethealiens.azurewebsites.net/api/"; // "http://10.0.2.2:8080/";

    static {
        setupRestClient();
    }

    private ApiClient(){}

    public static APIPlug get(){
        return REST_CLIENT;
    }

    public static  void setupRestClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        //REST_CLIENT = retrofit.create(APIPlug.class);
    }
}
