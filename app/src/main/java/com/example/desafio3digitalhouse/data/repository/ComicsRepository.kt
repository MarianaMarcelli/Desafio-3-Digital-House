package com.example.desafio3digitalhouse.data.repository

class ComicsRepository {

    private val client = ComicsEndpoint.endpoint

    suspend fun obterComics() = client.getComicsList()
}