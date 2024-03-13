package com.example.comics.domain.usecase

import com.example.comics.data.model.Comic
import kotlinx.coroutines.flow.Flow


interface GetComicsUseCase {
    operator fun invoke(): Flow<List<Comic>>
}
