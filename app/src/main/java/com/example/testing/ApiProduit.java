package com.example.testing;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.http.POST;
import retrofit.http.Query;


public interface ApiProduit {

    @POST("/produit/postProd")
    Call<String> postProduit(@Query("nomProd") String nomProd,
                             @Query("id_restau") int id_restau,
                             @Query("id_cat") int id_cat,
                             @Query("prixProd") Float prixProd,
                             @Query("id_unite") int id_unite);
}
