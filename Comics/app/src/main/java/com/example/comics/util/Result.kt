package com.example.comics.util

sealed class Result<out T> {
    class Success<T>(val data: T) : Result<T>()
    class Failure(val error: Exception) : Result<Nothing>()
}