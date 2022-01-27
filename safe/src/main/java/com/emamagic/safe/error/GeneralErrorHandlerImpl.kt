package com.emamagic.safe.error

import android.database.sqlite.SQLiteException
import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.NoInternetException
import com.emamagic.common_jvm.ServerConnectionException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketException
import java.net.UnknownHostException

abstract class GeneralErrorHandlerImpl : ErrorHandler {

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