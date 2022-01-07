package com.emamagic.safe

import android.database.sqlite.SQLiteException
import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.safe.error.ErrorHandler
import com.emamagic.safe.error.NoInternetException
import com.emamagic.safe.error.ServerConnectionException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketException
import java.net.UnknownHostException

abstract class SafeApi : ErrorHandler {

    suspend fun <T> safe(call: suspend () -> Response<T>): ResultWrapper<T> =
        withContext(Dispatchers.IO) { handleResponse { call() } }

    suspend fun <T, E> safe(
        call: suspend () -> Response<T>,
        mapper: (T) -> E
    ): ResultWrapper<E> =
        withContext(Dispatchers.IO) { handleResponse({ call() }, mapper) }


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

    override fun getError(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is IOException,
            is NoInternetException,
            is SocketException -> ErrorEntity.Network(message = "${throwable.message}")
            is SQLiteException -> ErrorEntity.Database(message = "${throwable.message}")
            is UnknownHostException,
            is ServerConnectionException -> ErrorEntity.Server(message = "${throwable.message}")
            is HttpException -> ErrorEntity.Api(
                message = throwable.response()?.message(),
                code = throwable.code(),
                errorBody = throwable.response()?.errorBody()?.string()
            )
            else -> ErrorEntity.Unknown(message = "${throwable.message}")
        }
    }

}