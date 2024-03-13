package com.example.comics.presentation.viewmodel

import com.example.comics.MainDispatcherRule
import com.example.comics.data.model.Comic
import com.example.comics.domain.usecase.GetComicsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ComicViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getComicsUseCase: GetComicsUseCase = mockk()
    private val viewModel = ComicViewModel(getComicsUseCase)

    @Test
    fun `test getComics success`() = runTest {
        val comics = listOf(
            Comic("Image 1", "Comic 1", "Sub 1"),
            Comic("Image 2", "Comic 2", "Sub 2")
        )
        coEvery { getComicsUseCase() } returns flowOf(comics)

        viewModel.getComics()

        assertEquals(comics, viewModel.comics.first())
    }

    @Test
    fun `test getComics empty result`() = runTest {
        coEvery { getComicsUseCase() } returns flowOf(emptyList())

        viewModel.getComics()

        assertEquals(Unit, viewModel.error.first())
    }
}
