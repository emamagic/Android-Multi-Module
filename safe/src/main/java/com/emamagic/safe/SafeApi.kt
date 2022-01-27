package com.emamagic.safe

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.NoInternetException
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.common_jvm.ServerConnectionException
import com.emamagic.safe.connectivity.Connectivity
import com.emamagic.safe.connectivity.ConnectivityPublisher
import com.emamagic.safe.connectivity.ConnectivityStatus
import com.emamagic.safe.error.GeneralErrorHandlerImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.withLock
import retrofit2.Response
import java.io.IOException

abstract class SafeApi : GeneralErrorHandlerImpl() {

    override suspend fun <T> safe(
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double,
        networkCall: suspend () -> Response<T>
    ): ResultWrapper<T> =
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

    override suspend fun <T, E> safe(
        times: Int,
        initialDelay: Long,
        maxDelay: Long,
        factor: Double,
        networkCall: suspend () -> Response<T>,
        mapping: (T) -> E
    ): ResultWrapper<E> =
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


    private inline fun <T> handleResponse(call: () -> Response<T>): ResultWrapper<T> {
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

    private inline fun <T, E> handleResponse(
        call: () -> Response<T>,
        noinline converter: (T) -> E
    ): ResultWrapper<E> {
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
    ): T = Const.getMutex.withLock {
        if (!Const.shouldRetryNetworkCall) coroutineScope.cancel() // disable retryIo api call

        var currentDelay = initialDelay
        repeat(times - 1) { index ->
            try {
                return block()
            } catch (e: IOException) {
                if (index == times - 2 && (e is NoInternetException || e is ServerConnectionException)) {
                    ConnectivityPublisher.notifySubscribers(Connectivity(Const.DISCONNECT))
                }
            }
            if (Const.shouldRetryNetworkCall) {
                delay(currentDelay)
                currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
            }
        }
        return block()
    }

}