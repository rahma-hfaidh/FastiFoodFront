package com.example.testing;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit2.http.POST;

public interface ApiCom {

    @GET("facteur/GetAllFacteursByIdClient/:id_client")
    Call<List<commande>> getFactByIdClient(@Query("id_client") int id_client);




 }