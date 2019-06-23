package com.example.unidirectionalstateflow.data.repository

sealed class Result<T> {
    data class Content<T>(val data: T) : Result<T>()
    data class Error<T>(val data: T) : Result<T>()
}