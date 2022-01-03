package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

object ErrorRepository {

    private val _errorMessage: Channel<String> = Channel()
    val errorMessage = _errorMessage.receiveAsFlow()

    fun handleErrorMessage(errorEntity: ErrorEntity) {
     //   Timber.e("${errorEntity.message} // ${errorEntity.code} // ${errorEntity.errorBody}")
        val message: String = when (errorEntity) {
            is ErrorEntity.Api -> "There is problem to network communication"
            is ErrorEntity.Database -> "There is problem to record information"
            is ErrorEntity.Network -> "pls check your connectivity"
            is ErrorEntity.Server -> "server has problem try later"
            is ErrorEntity.Unknown -> "Unknown Error"
        }
        CoroutineScope(Dispatchers.IO).launch { _errorMessage.send(message) }
    }


}