package com.victor.crypton.domain.util

sealed class Resource<T> {
    class Success<T>(val value: T) : Resource<T>()
    class Failure<T>(val errorMessage: String) : Resource<T>()
    class Loading<T>(val value: T? = null) : Resource<T>()
}
