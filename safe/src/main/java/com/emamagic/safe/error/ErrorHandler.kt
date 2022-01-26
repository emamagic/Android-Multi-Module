package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.ResultWrapper
import retrofit2.Response

interface ErrorHandler {

    suspend fun <T> safe(call: suspend () -> Response<T>): ResultWrapper<T>

    suspend fun <T, E> safe(
        networkCall: suspend () -> Response<T>,
        mapping: (T) -> E
    ): ResultWrapper<E>

    fun getError(throwable: Throwable): ErrorEntity

    suspend fun <T> retryIO(
        times: Int = Int.MAX_VALUE,
        initialDelay: Long = 100,
        maxDelay: Long = 1000,
        factor: Double = 2.0,
        block: suspend () -> T): T
}