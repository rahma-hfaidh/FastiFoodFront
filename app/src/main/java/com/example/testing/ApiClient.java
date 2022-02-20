package com.example.testing;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiClient {

    private static final String BASE_URL="http://172.16.21.123:5000/";
    private static Retrofit retrofit =null;


    public static Retrofit getClient()
    {

        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
