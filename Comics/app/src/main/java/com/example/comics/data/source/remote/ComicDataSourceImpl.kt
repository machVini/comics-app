package com.example.comics.data.source.remote

import com.example.comics.data.mapper.toModel
import com.example.comics.data.model.Comic
import com.example.comics.data.source.remote.api.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ComicDataSourceImpl(private val api: Api) : ComicDataSource {
    override fun getComics(): Flow<List<Comic>> = flow {
        try {
            val response = api.getComics()
            if (response.isSuccessful && response.body() != null)
                emit(response.body()!!.data.results.map { it.toModel() })
        } catch (e: HttpException) {
            emit(emptyList())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
