package com.example.comics.data.repository

import com.example.comics.data.model.Comic
import com.example.comics.data.source.remote.ComicDataSource
import kotlinx.coroutines.flow.Flow

class ComicRepositoryImpl(private val comicDataSource: ComicDataSource) : ComicRepository {
    override fun getComics(): Flow<List<Comic>> {
        return comicDataSource.getComics()
    }
}
