package com.example.comics.data.repository

import com.example.comics.data.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicRepository {
    fun getComics(): Flow<List<Comic>>
}
