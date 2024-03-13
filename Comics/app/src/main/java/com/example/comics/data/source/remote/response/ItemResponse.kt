package com.example.comics.data.source.remote.response

data class ItemResponse(
    val data: DataModel
)

data class DataModel(
    val results: List<ResultModel>
)

data class ResultModel(
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailModel
)

data class ThumbnailModel(
    val path: String,
    val extension: String,
)