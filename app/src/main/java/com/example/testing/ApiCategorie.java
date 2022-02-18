package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiCategorie {

    @GET("categorie/GetCatByIdRestau/")
    Call<List<Categorie>> getCatByIdRestau(@Query("id_restau") int id_restau);
}
