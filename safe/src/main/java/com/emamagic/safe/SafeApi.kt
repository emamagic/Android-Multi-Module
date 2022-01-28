package com.emamagic.safe

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.NoInternetException
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.common_jvm.ServerConnectionException
import com.emamagic.safe.connectivity.Connectivity
import com.emamagic.safe.connectivity.ConnectivityPublisher
import com.emamagic.safe.error.GeneralErrorHandlerImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.withLock
import retrofit2.Response
import java.io.IOException

abstract class SafeApi : GeneralErrorHandlerImpl() {

    override suspend fun <ResultType> getSafe(
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double,
        networkCall: suspend () -> Response<ResultType>
    ): ResultWrapper<ResultType> =
        withContext(Dispatchers.IO) {
            handleResponse {
                retryIO(
                    times,
                    initialDelay,
                    maxDelay,
                    factor,
                    this
                ) { networkCall() }
            }
        }

    override suspend fun <ResultType, RequestType> getSafe(
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double,
        networkCall: suspend () -> Response<RequestType>,
        mapping: (RequestType) -> ResultType,
    ): ResultWrapper<ResultType> =
        withContext(Dispatchers.IO) {
            handleResponse({
                retryIO(
                    times,
                    initialDelay,
                    maxDelay,
                    factor,
                    this
                ) { networkCall() }
            }, mapping)
        }


    private inline fun <ResultType> handleResponse(call: () -> Response<ResultType>): ResultWrapper<ResultType> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let {
                    return ResultWrapper.Success(
                        data = it,
                        code = response.code()
                    )
                }
            }
            return ResultWrapper.Failed(
                error = ErrorEntity.Api(response.errorBody()?.string()),
            )
        } catch (t: Throwable) {
            ResultWrapper.Failed(getError(t))
        }
    }

    // NetworkBoundResource
    private inline fun <ResultType, RequestType> steamSafe(
        crossinline databaseQuery: () -> Flow<ResultType>,
        crossinline networkCall: suspend () -> RequestType,
        crossinline saveCallResult: suspend (RequestType) -> Unit,
        crossinline shouldFetch: (ResultType) -> Boolean = { true },
        crossinline onFetchSuccess: () -> Unit = { },
        crossinline onFetchFailed: (ErrorEntity) -> Unit = { }
    ) = channelFlow {
        val data = databaseQuery().first()

        if (shouldFetch(data)) {
            val loading = launch {
                databaseQuery().collect { send(ResultWrapper.FetchLoading(it)) }
            }
            try {
                saveCallResult(networkCall())
                onFetchSuccess()
                loading.cancel()
                databaseQuery().collect { send(ResultWrapper.Success(it)) }
            } catch (t: Throwable) {
                onFetchFailed(getError(t))
                loading.cancel()
                databaseQuery().collect { send(ResultWrapper.Failed(getError(t), it)) }
            }
        } else {
            databaseQuery().collect { send(ResultWrapper.Success(it)) }
        }
    }

    private inline fun <RequestType, ResultType> handleResponse(
        call: () -> Response<RequestType>,
        noinline converter: (RequestType) -> ResultType
    ): ResultWrapper<ResultType> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let {
                    return ResultWrapper.Success(
                        data = converter(it),
                        code = response.code()
                    )
                }
            }
            return ResultWrapper.Failed(
                error = ErrorEntity.Api(response.errorBody()?.string()),
            )
        } catch (t: Throwable) {
            ResultWrapper.Failed(getError(t))
        }

    }

    private suspend fun <T> retryIO(
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double,
        coroutineScope: CoroutineScope,
        block: suspend () -> T
    ): T = General.getMutex.withLock {
        if (!General.shouldRetryNetworkCall) coroutineScope.cancel() // disable retryIo api call

        var currentDelay = initialDelay
        repeat(times - 1) { index ->
            try {
                return block()
            } catch (e: IOException) {
                if (index == times - 2 && (e is NoInternetException || e is ServerConnectionException)) {
                    ConnectivityPublisher.notifySubscribers(Connectivity(General.DISCONNECT))
                }
            }
            if (General.shouldRetryNetworkCall) {
                delay(currentDelay)
                currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
            }
        }
        return block()
    }

}