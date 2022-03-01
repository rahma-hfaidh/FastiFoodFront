package com.example.testing;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;


public interface ApiProduit {

    @POST("/produit/postProd")
    Call<String> postProduit(@Query("nomProd") String nomProd,
                             @Query("id_restau") int id_restau,
                             @Query("id_cat") int id_cat,
                             @Query("prixProd") Float prixProd,
                             @Query("id_unite") int id_unite);

    @GET("produit/GetProdByIdCat/:id_cat")
    Call<List<Produit>> getProdByIdCat(@Query("id_cat") int id_cat);

    @GET("produit/images/:id_prod")
    Call<String> getPicture(@Query("id_prod") int id_prod);
}
