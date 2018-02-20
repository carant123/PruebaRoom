package com.proyecto.qr.retrofitrxjava;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos on 15/02/2018.
 */

public class RestClient {

    private static final String BASE_URL = "https://reqres.in";
    private Service service;

    public RestClient()
    {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://pokeapi.co/api/v2/")
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();



        service = retrofit.create(Service.class);


    }

    public Service getService()
    {
        return service;
    }


}
