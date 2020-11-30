package com.example.desafio3digitalhouse.lista_hq.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio3digitalhouse.lista_hq.model.ComicsModel
import com.example.desafio3digitalhouse.lista_hq.repository.ComicsRepository
import kotlinx.coroutines.Dispatchers

class ComicsViewModel(private val repository: ComicsRepository) : ViewModel() {

    private var _comics: List<ComicsModel> = listOf()

    fun obterLista() = liveData(Dispatchers.IO) {
        val response = repository.obterComicsList()

        _comics = response

        emit(response)
    }

    class ComicsViewModelFactory(
        private val repository: ComicsRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicsViewModel(repository) as T
        }
    }


}