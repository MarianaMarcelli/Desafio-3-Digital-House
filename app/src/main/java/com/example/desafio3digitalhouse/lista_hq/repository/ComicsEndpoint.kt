package com.example.desafio3digitalhouse.lista_hq.repository

import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.example.desafio3digitalhouse.data.api.NetworkUtils
import retrofit2.http.GET

interface ComicsEndpoint {
    @GET("v1/public/comics")
    suspend fun obterLista(
//        @Query("ts") timestamp : String,
//        @Query("apikey") apikey : String,
//        @Query("hash") hash : String
    ): List<ComicsModel>

    companion object{
        val endpoint: ComicsEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicsEndpoint::class.java)
        }
    }
}