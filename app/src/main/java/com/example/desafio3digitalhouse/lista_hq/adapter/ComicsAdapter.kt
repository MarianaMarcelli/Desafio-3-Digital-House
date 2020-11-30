package com.example.desafio3digitalhouse.lista_hq.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.lista_hq.model.ComicsModel

class ComicsAdapter(private val dataSet : List<ComicsModel>): RecyclerView.Adapter<ComicsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hq_model, parent, false)
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
      holder.bind(dataSet[position])
    }

    override fun getItemCount() =  dataSet.size
    }
