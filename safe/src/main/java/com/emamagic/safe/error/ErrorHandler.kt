package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.safe.policy.RetryPolicy
import retrofit2.Response

interface ErrorHandler {

    suspend fun <ResultType> getSafe(
        retryPolicy: RetryPolicy = RetryPolicy(),
        remoteFetch: suspend () -> Response<ResultType>): ResultWrapper<ResultType>

    suspend fun <ResultType, RequestType> getSafe(
        retryPolicy: RetryPolicy = RetryPolicy(),
        remoteFetch: suspend () -> Response<RequestType>,
        mapping: (RequestType) -> ResultType
    ): ResultWrapper<ResultType>

    fun getError(throwable: Throwable): ErrorEntity

}