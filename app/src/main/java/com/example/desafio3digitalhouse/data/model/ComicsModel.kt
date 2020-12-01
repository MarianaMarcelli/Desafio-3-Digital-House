package com.example.desafio3digitalhouse.data.model

data class ComicsModel(

    val id : Int,
    val title: String,
    val issueNumber: Double,
    val description: String,
    val prices: List<ComicPriceModel>,
    val pageCount: Int,
    val dates: List<ComicDateModel>,
    val thumbnail: ImageModel,
    val images: List<ImageModel>

)


