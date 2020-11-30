package com.example.desafio3digitalhouse.lista_hq.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.lista_hq.model.ComicDateModel
import com.example.desafio3digitalhouse.lista_hq.model.ComicPriceModel
import com.example.desafio3digitalhouse.lista_hq.model.ComicsModel
import com.example.desafio3digitalhouse.lista_hq.model.ImageModel
import com.squareup.picasso.Picasso

class ComicsViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    private var numero= itemView.findViewById<TextView>(R.id.txtComicNumber)
    private var imagemCapa = itemView.findViewById<ImageView>(R.id.imageComic)

    fun bind(comic : ComicsModel) {
        numero.text = comic.issueNumber.toString()

        Picasso.get()
            .load(comic.thumbnail)
            .into(imagemCapa)
    }

}

//private var titulo = itemView.findViewById<>(R.id.)
//private var numero= itemView.findViewById<>(R.id.)
//private var descricao = itemView.findViewById<>(R.id.)
//private var preco = itemView.findViewById<>(R.id.)
//private var numeroPaginas = itemView.findViewById<>(R.id.)
//private var imagemCapa = itemView.findViewById<>(R.id.)
//private var imagemPromocional = itemView.findViewById<>(R.id.)
