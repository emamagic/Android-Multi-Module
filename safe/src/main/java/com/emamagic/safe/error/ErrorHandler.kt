package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.ResultWrapper
import retrofit2.Response

interface ErrorHandler {

    suspend fun <T> safe(
        times: Int = Int.MAX_VALUE,
        initialDelay: Long = 100,
        maxDelay: Long = 1000,
        factor: Double = 2.0,
        call: suspend () -> Response<T>): ResultWrapper<T>

    suspend fun <T, E> safe(
        times: Int = Int.MAX_VALUE,
        initialDelay: Long = 100,
        maxDelay: Long = 1000,
        factor: Double = 2.0,
        networkCall: suspend () -> Response<T>,
        mapping: (T) -> E
    ): ResultWrapper<E>

    fun getError(throwable: Throwable): ErrorEntity

}