package com.example.comics.data.mapper

import com.example.comics.data.model.Comic
import com.example.comics.data.source.remote.response.ResultModel

fun ResultModel.toModel(): Comic = Comic(
    image = "${thumbnail.path}.${thumbnail.extension}",
    title = title,
    subtitle = description ?: "Sem descricao"
)

