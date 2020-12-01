package com.example.desafio3digitalhouse.data.model

class DataModel<T> (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
)