package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiComm {
    @GET("commande/GetCommandesAcceptByIdRestau/:id_restau")
    Call<List<commande>> getCommandesAcceptByIdRestau(@Query("id_restau") int id_restau);
    @GET("commande/GetCommandesRefuseByIdRestau/:id_restau")
    Call<List<commande>> getCommandesRefuseByIdRestau(@Query("id_restau") int id_restau);
}
