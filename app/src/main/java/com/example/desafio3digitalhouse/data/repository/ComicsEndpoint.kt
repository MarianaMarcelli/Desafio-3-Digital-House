package com.example.desafio3digitalhouse.data.repository

import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.example.desafio3digitalhouse.data.api.NetworkUtils
import com.example.desafio3digitalhouse.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicsEndpoint {
    @GET("v1/public/comics")
    suspend fun getComicsList(): ResponseModel<ComicsModel>

    @GET("v1/public/comics/{comicId}")
    suspend fun getComic(@Path("id") id: Int): ResponseModel<ComicsModel>

    companion object {
        val endpoint: ComicsEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicsEndpoint::class.java)
        }
    }
}