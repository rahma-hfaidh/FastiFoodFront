package com.example.testing;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiProduit {

    @POST("/produit/postProduit")
    Call<ResponseBody> postProduit(@Query("id_cat") int id_cat,
                                   @Query("id_unite") int id_unite,
                                   @Query("nomProd") String nomProd,
                                   @Query("prixProd") Float prixProd);
}
