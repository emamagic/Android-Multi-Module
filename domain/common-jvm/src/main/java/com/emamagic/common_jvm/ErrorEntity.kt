package com.emamagic.common_jvm

sealed class ErrorEntity(
        val message: String? = null,
        val code: Int? = null,
        val errorBody: String? = null
) {
    class Network(message: String) : ErrorEntity(message = message)
    class Api(message: String? ,code: Int?= null ,errorBody: String? = null) : ErrorEntity(message = message ,code = code ,errorBody = errorBody)
    class Database(message: String): ErrorEntity(message = message)
    class Server(message: String): ErrorEntity(message = message)
    class Unknown(message: String) : ErrorEntity(message = message)
}