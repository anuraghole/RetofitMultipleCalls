package com.example.aurag.slimframeworkdemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://localhost/myslimprojects/public";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {


            OkHttpClient.Builder clientBuilder=new OkHttpClient.Builder();

            //It is use to store the log of requests
            HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            if (BuildConfig.DEBUG){
                clientBuilder.addInterceptor(httpLoggingInterceptor);
            }
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(clientBuilder.build())
                    .build();
        }
        return retrofit;
    }
}
