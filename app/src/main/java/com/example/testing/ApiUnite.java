package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiUnite {
    @GET("unite/GetUnitByIdCat//")
    Call<List<Unite>> getUnitByIdCat(@Query("id_cat") int id_cat);
}
