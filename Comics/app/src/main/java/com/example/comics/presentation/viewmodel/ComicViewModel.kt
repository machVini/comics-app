package com.example.comics.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comics.data.model.Comic
import com.example.comics.domain.usecase.GetComicsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ComicViewModel(private val getComicsUseCase: GetComicsUseCase) : ViewModel() {

    private val _comics = MutableSharedFlow<List<Comic>>()
    val comics = _comics.asSharedFlow()

    private val _error = MutableSharedFlow<Unit?>()
    val error = _error.asSharedFlow()

    fun getComics() {
        viewModelScope.launch {
            getComicsUseCase().collect { result ->
                if (result.isNotEmpty()) {
                    _comics.emit(result)
                } else {
                    _error.emit(Unit)
                }
            }
        }
    }
}
