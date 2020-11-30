package com.example.desafio3digitalhouse.lista_hq.repository

class ComicsRepository {

    private val client = ComicsEndpoint.endpoint

    suspend fun obterComicsList() = client.obterLista()
}