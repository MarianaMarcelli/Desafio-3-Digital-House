package com.example.desafio3digitalhouse.lista_hq.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio3digitalhouse.data.model.ComicsModel
import com.example.desafio3digitalhouse.data.repository.ComicsRepository
import kotlinx.coroutines.Dispatchers

class ComicsViewModel(private val _repository: ComicsRepository) : ViewModel() {

    private var _comics = listOf<ComicsModel>()

    fun obterComicsList() = liveData(Dispatchers.IO) {
        val response = _repository.obterComics()

        _comics = response.data.results
        emit(response.data.results)
    }

    class ComicsViewModelFactory(
        private val _repository: ComicsRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicsViewModel(_repository) as T
        }
    }
}