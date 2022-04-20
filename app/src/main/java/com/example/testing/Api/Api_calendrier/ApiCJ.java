package com.example.testing.Api.Api_calendrier;

import com.example.testing.Models.CALENDARJ;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiCJ {
    @GET("facteur/commandesbydate/:date")
    Call<List<CALENDARJ>> getComtBydate(@Query("date") String date);

}
