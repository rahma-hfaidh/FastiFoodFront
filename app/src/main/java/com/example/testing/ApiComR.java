package com.example.testing;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit2.http.POST;

public interface ApiComR {
    @GET("commande/GetAllCommandesByIdRestau/:id_restau")
    Call<List<commandeRestau>> getFactByIdRestau(@Query("id_restau") int id_restau);

    @POST("commande/putReponse")
    retrofit2.Call<ResponseBody> putRep(@retrofit2.http.Query("id_com") int id_com,
                                        @retrofit2.http.Query("reponse") String reponse);
}
