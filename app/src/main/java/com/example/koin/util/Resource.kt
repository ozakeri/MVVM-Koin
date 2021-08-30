package com.example.koin.util

data class Resource<out T>(val data: T?, val status: Status, val msg: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(data, Status.SUCCESS, null)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(data, Status.LOADING, null)
        }

        fun <T> error(msg: String?, data: T?): Resource<T> {
            return Resource(data, Status.ERROR, msg)
        }
    }
}