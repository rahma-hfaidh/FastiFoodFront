package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface ApiCategorie {

    @GET("categoie/GetCatByIdRestau/:id_restau")
    Call<List<Categorie>> getCatByIdRestau(@Query("id_restau") int id_restau);
}
