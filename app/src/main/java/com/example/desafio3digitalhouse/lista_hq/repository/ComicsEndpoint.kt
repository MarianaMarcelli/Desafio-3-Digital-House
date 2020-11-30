package com.example.desafio3digitalhouse.lista_hq.repository

import com.example.desafio3digitalhouse.lista_hq.model.ComicsModel
import com.example.desafio3digitalhouse.lista_hq.network.NetworkUtils
import retrofit2.http.GET

interface ComicsEndpoint {
    @GET("v1/public/comics")
    suspend fun obterLista(): List<ComicsModel>

    companion object{
        val endpoint: ComicsEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicsEndpoint::class.java)
        }
    }
}