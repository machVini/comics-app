package com.example.comics.data.source.remote


import com.example.comics.data.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicDataSource {
    fun getComics(): Flow<List<Comic>>
}
