package com.example.comics.data.source.remote.api


import com.example.comics.data.source.remote.response.ItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "b7e14bab409c70a5c4e7c2b319c09d7b"
private const val TIMESTAMP = "1682982412"
private const val HASH = "3482f01e9bf207a437a4b621c91339ad"

interface Api {
    @GET("comics")
    suspend fun getComics(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("ts") timestamp: String = TIMESTAMP,
        @Query("hash") hash: String = HASH
    ): Response<ItemResponse>
}
