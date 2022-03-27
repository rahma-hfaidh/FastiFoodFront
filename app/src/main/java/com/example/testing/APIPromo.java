package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface APIPromo {

        @GET("promotion/GetlistPromo")
        Call<List<Promotion>> getListPromo();

        @GET("promotion/images/:id_promo")
        Call<String> getPicture(@Query("id_promo") int id_promo);
    }
