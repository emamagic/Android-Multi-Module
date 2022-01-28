package com.emamagic.safe.connectivity

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.LiveData
import com.emamagic.safe.Const
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConnectionLiveData(context: Context, val lifecycleScope: CoroutineScope? = null) : LiveData<ConnectivityStatus>(), ConnectivityPublisherDelegate {

    val TAG = "C-Manager"

    private lateinit var networkCallback: ConnectivityManager.NetworkCallback
    private val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    private lateinit var apiCalls: List<suspend () -> Unit>

    fun enableOfflineMode() {
        Const.shouldRetryNetworkCall = false
        postValue(ConnectivityStatus.OFFLINE_MODE)
    }

    fun setRefreshVisibleFragmentFunc(functions: List<suspend () -> Unit>) { apiCalls = functions }

    fun disableOfflineMode() {
        Const.shouldRetryNetworkCall = true
        refreshVisibleFragmentFuncIfEnable(apiCalls)
    }

    fun connect() {
        Log.e(TAG, "connect: ", )
        Const.shouldRetryNetworkCall = true
        refreshVisibleFragmentFuncIfEnable(apiCalls)
        postValue(ConnectivityStatus.CONNECT)
    }

    fun disconnect() {
        Log.e(TAG, "disconnect: ", )
        Const.shouldRetryNetworkCall = false
        postValue(ConnectivityStatus.DISCONNECT)
    }

    override fun onActive() {
        Log.d(TAG, "onAvailable")
        networkCallback = createNetworkCallback()
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NET_CAPABILITY_INTERNET)
            .build()
        cm.registerNetworkCallback(networkRequest, networkCallback)
        ConnectivityPublisher.subscribe(this, Const.CONNECT)
        ConnectivityPublisher.subscribe(this, Const.DISCONNECT)
    }

    override fun onInactive() {
        cm.unregisterNetworkCallback(networkCallback)
        ConnectivityPublisher.unSubscribe(this, Const.CONNECT)
        ConnectivityPublisher.unSubscribe(this, Const.DISCONNECT)
    }

    private fun createNetworkCallback() = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            val networkCapabilities = cm.getNetworkCapabilities(network)
            val hasInternetCapability = networkCapabilities?.hasCapability(NET_CAPABILITY_INTERNET)
            Log.d(TAG, "onAvailable: ${network}, $hasInternetCapability")
            if (hasInternetCapability == true) {
                // check if this network actually has internet
                CoroutineScope(Dispatchers.IO).launch {
                    val hasInternet = DoesNetworkHaveInternet.execute()
                    if (hasInternet) {
                        withContext(Dispatchers.Main) {
                            Log.d(TAG, "onAvailable: adding network. $network")
                            connect()
                        }
                    }
                }
            }
        }


        override fun onLost(network: Network) {
            Log.d(TAG, "onLost: $network")
            disconnect()
        }

    }

    override fun receiveConnectivity(connectivity: Connectivity) {
        Log.e(TAG, "receiveConnectivity: ${connectivity.status}")
        when (connectivity.status) {
            Const.CONNECT -> connect()
            Const.DISCONNECT -> disconnect()
            Const.OFFLINE_MODE -> enableOfflineMode()
        }
    }

    private fun refreshVisibleFragmentFuncIfEnable(functions: List<suspend () -> Unit>) {
        if (this::apiCalls.isInitialized) {
            lifecycleScope?.launch(Dispatchers.IO) {
                functions.forEach { it() }
            }
        }
    }

}