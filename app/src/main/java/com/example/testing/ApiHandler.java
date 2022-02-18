package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiHandler {

    @GET("produit/GetAllRepas")
    Call<List<Produit>> getAllRepas();

    @GET("produit/GetAllDesserts")
    Call<List<Produit>> getAllDesserts();

    @GET("produit/GetAllBoissons")
    Call<List<Produit>> getAllBoissons();

    @FormUrlEncoded
    @GET("produit/images/:id_prod")
    Call<String> getPicture(@Field("id_prod") int id_prod);




}
