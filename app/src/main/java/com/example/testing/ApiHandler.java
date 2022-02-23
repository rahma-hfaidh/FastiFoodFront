package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface ApiHandler {

    @GET("produit/GetAllRepas")
    Call<List<Produit>> getAllRepas();

    @GET("produit/GetAllDesserts")
    Call<List<Produit>> getAllDesserts();

    @GET("produit/GetAllBoissons")
    Call<List<Produit>> getAllBoissons();


    @GET("produit/images/:id_prod")
    Call<String> getPicture(@Query("id_prod") int id_prod);





}
