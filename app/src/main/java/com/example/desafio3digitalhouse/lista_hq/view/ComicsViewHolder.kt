package com.example.desafio3digitalhouse.lista_hq.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.squareup.picasso.Picasso

class ComicsViewHolder (private val _itemView: View): RecyclerView.ViewHolder(_itemView) {

    private var numero= _itemView.findViewById<TextView>(R.id.txtComicNumber)
    private var imagemCapa = _itemView.findViewById<ImageView>(R.id.imageComic)

    fun bind(comic : ComicsModel) {
        numero.text = comic.issueNumber.toString()

        Picasso.get()
            .load(comic.thumbnail.converterImagem())
            .into(imagemCapa)
    }

}

//private var titulo = itemView.findViewById<>(R.id.)
//private var dataPublicacao = itemView.findViewById<>(R>id.)
//private var descricao = itemView.findViewById<>(R.id.)
//private var preco = itemView.findViewById<>(R.id.)
//private var numeroPaginas = itemView.findViewById<>(R.id.)
//private var imagemPromocional = itemView.findViewById<>(R.id.)