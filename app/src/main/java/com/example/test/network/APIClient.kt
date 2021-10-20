package com.example.test.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {

        var retrofit: Retrofit? = null

        fun getClient(): Retrofit {

            if (retrofit == null) {

                retrofit= Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }

            return retrofit!!

        }
    }
}