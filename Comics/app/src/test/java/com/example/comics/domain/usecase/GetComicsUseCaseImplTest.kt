package com.example.comics.domain.usecase

import com.example.comics.data.model.Comic
import com.example.comics.data.repository.ComicRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetComicsUseCaseImplTest {

    private val mockRepository = mockk<ComicRepository>()
    private val useCase: GetComicsUseCase = GetComicsUseCaseImpl(mockRepository)

    @Test
    fun `invoke() should return comics when successful`() = runBlocking {
        val comics = listOf(Comic("Image Test", "Title test", "Subtitle test"))
        coEvery { mockRepository.getComics() } returns flow { emit(comics) }

        val flow = useCase.invoke()

        flow.collect { result ->
            assertEquals(comics, result)
        }
    }

    @Test
    fun `invoke() should return error when failed`() = runBlocking {
        coEvery { mockRepository.getComics() } returns flow {
            emit(emptyList())
        }

        val result = useCase.invoke().toList()

        assertTrue(result.first().isEmpty())
    }



}
