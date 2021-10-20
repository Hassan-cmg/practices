package com.example.test.network

import com.example.test.models.MoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIinterface {


    @GET("movielist.json")
    fun getMoviesList(): Call<List<MoviesModel>>
}
