package com.example.gsb_visite;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbVisite {

    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @GET("visiteurs")
    Call<Visiteurs> getVisiteurs();


    @GET("praticiens/{id}")
    Call<Praticien> getPraticiens(@Header("Authorization") String authorization, @Path("id") String id);

    @GET("visites/{id}")
    Call<Visite> getVisites(@Header("Authorization") String authorization, @Path("id") String id);
}

