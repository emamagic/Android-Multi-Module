package com.emamagic.common_jvm

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object DoesNetworkHaveInternet {

    val TAG = "C-Manager"
    fun execute(): Boolean{
        return try {
            print("$TAG PINGING google")
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8" ,53) ,1500)
            socket.close()
            print("$TAG PING success")
            true
        }catch (e: IOException){
            print("$TAG No internet connection -> ${e.message}")
            false
        }
    }
}