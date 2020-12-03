package com.example.desafio3digitalhouse.data.model

data class ImageModel(
    val path: String,
    val extension: String
) {
    fun converterImagem(size: String?): String {
        return "$path/$size.$extension".replace("http://", "https://")
    }
}
