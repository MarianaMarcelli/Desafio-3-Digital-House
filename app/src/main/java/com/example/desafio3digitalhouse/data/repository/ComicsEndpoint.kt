package com.example.desafio3digitalhouse.data.repository

import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.example.desafio3digitalhouse.data.api.NetworkUtils
import com.example.desafio3digitalhouse.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsEndpoint {
    @GET("v1/public/comics")
    suspend fun getComicsList(): ResponseModel<ComicsModel>

    companion object {
        val endpoint: ComicsEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicsEndpoint::class.java)
        }
    }
}