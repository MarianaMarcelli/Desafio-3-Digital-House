package com.example.desafio3digitalhouse.lista_hq.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.data.model.ComicsModel

class ComicsAdapter(
    private val _dataSetComics: List<ComicsModel>,
    private val _listener: (ComicsModel) ->Unit
) :
    RecyclerView.Adapter<ComicsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hq_model, parent, false)
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val item = _dataSetComics[position]

        holder.bind(item)
        holder.itemView.setOnClickListener { _listener(item) }
    }

    override fun getItemCount() = _dataSetComics.size
}
