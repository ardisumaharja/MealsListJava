package com.infogramtelemedia.foodlist.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitIntance {
    private static Retrofit retrofitIntance;
    private static final String API_URL = "https://www.themealdb.com";
    public static retrofit2.Retrofit getRetrofitIntance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofitIntance == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            retrofitIntance = new retrofit2.Retrofit.Builder()
                    .baseUrl(API_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofitIntance;
    }
}
