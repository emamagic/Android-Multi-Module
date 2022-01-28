package com.emamagic.network.interceptor

import com.emamagic.common_jvm.ServerConnectionException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.net.SocketTimeoutException
import javax.inject.Inject

@Suppress("UNREACHABLE_CODE")
class ServerConnection @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response { return onOnIntercept(chain) }

    private fun onOnIntercept(chain: Interceptor.Chain): Response {
        try {
            val response: Response = chain.proceed(chain.request())
            return response.newBuilder().body(ResponseBody.create(response.body?.contentType()!! ,response.body?.string()!!))
                .build()
        } catch (exception: SocketTimeoutException) {
            throw ServerConnectionException("Server Is Not Available")
        }
        return chain.proceed(chain.request())
    }

}