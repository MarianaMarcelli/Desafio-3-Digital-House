package com.example.desafio3digitalhouse.lista_hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3digitalhouse.R
import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.example.desafio3digitalhouse.data.model.ResponseModel
import com.example.desafio3digitalhouse.data.repository.ComicsRepository
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
        return inflater.inflate(R.layout.fragment_lista_hqs, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _recyclerView = _view.findViewById(R.id.recyclerComics)

        val manager = GridLayoutManager(view.context, 3)


        _listaAdapter = ComicsAdapter(_listaComics) {
            val bundle = bundleOf(

                "DATAPUBLICACAO" to it.dates[0].date,
                "DESCRICAO" to it.description,
                "PRECO" to it.prices[0].price.toString(),
                "PAGINAS" to it.pageCount.toString(),
                "TITULO" to it.title,
                "IMAGEM" to it.thumbnail.converterImagem("landscape_medium"),
                "CAPA" to it.thumbnail.converterImagem("portrait_uncanny")
            )

            val navController = findNavController()
            navController.navigate(R.id.action_listaHQsFragment_to_infoHqFragment, bundle)
        }

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

        _viewModel.obterComicsList().observe(viewLifecycleOwner) {
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