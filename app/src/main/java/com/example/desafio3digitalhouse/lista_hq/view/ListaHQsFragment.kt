package com.example.desafio3digitalhouse.lista_hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.lista_hq.adapter.ComicsAdapter
import com.example.desafio3digitalhouse.lista_hq.model.ComicsModel
import com.example.desafio3digitalhouse.lista_hq.repository.ComicsRepository
import com.example.desafio3digitalhouse.lista_hq.viewmodel.ComicsViewModel

class ListaHQsFragment : Fragment() {

    private lateinit var _viewModel: ComicsViewModel
    private lateinit var _view: View
    private lateinit var _listaAdapter: ComicsAdapter
    private lateinit var _recyclerView: RecyclerView

    private var _listaComics = mutableListOf<ComicsModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_hqs, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _recyclerView = _view.findViewById(R.id.recyclerComics)

        val manager = GridLayoutManager(view.context, 3)

        _listaAdapter = ComicsAdapter(_listaComics)

        _recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this, ComicsViewModel.ComicsViewModelFactory(
                ComicsRepository()
            )
        ).get(ComicsViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner) {
            exibirLista(it)
        }
    }

    private fun exibirLista(lista: List<ComicsModel>) {
        lista.let {
            _listaComics.addAll(lista)
            _listaAdapter.notifyDataSetChanged()
        }

    }
}