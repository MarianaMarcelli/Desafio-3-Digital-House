package com.example.desafio3digitalhouse.data.model

data class ResponseModel<T> (
    val code: Int,
    val data: DataModel<T>
)