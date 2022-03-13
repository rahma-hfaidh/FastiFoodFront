package com.example.testing;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface APICoursier {
    @GET("coursier/GetCoursiersByF/:id_fact")
    Call<List<Coursier>> getCoursierByIdF(@Query("id_fact") int id_fact);
}
