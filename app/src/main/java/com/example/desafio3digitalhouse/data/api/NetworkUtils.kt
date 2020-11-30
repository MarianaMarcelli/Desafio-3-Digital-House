package com.example.desafio3digitalhouse.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {
        fun getRetrofitInstance(baseUrl: String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private const val BASE_URL = "https://gateway.marvel.com/"
    }

}