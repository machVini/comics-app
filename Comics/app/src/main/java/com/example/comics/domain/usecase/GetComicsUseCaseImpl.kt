package com.example.comics.domain.usecase

import com.example.comics.data.model.Comic
import com.example.comics.data.repository.ComicRepository
import kotlinx.coroutines.flow.Flow

class GetComicsUseCaseImpl(private val comicRepository: ComicRepository) : GetComicsUseCase {
    override fun invoke(): Flow<List<Comic>> {
        return comicRepository.getComics()
    }
}
