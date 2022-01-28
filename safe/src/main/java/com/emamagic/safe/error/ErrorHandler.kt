package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.ResultWrapper
import retrofit2.Response

interface ErrorHandler {

    suspend fun <ResultType> getSafe(
        times: Int = 5,
        initialDelay: Long = 1000,
        maxDelay: Long = 10000,
        factor: Double = 2.0,
        networkCall: suspend () -> Response<ResultType>): ResultWrapper<ResultType>

    suspend fun <ResultType, RequestType> getSafe(
        times: Int = 5,
        initialDelay: Long = 1000,
        maxDelay: Long = 10000,
        factor: Double = 2.0,
        networkCall: suspend () -> Response<RequestType>,
        mapping: (RequestType) -> ResultType
    ): ResultWrapper<ResultType>

    fun getError(throwable: Throwable): ErrorEntity

}