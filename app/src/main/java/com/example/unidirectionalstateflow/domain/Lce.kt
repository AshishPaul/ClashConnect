package com.example.unidirectionalstateflow.domain

sealed class Lce<T> {
    class Loading<T> : Lce<T>()
    data class Content<T>(val data: T) : Lce<T>()
    data class Error<T>(val data: T) : Lce<T>()
}