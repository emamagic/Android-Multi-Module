package com.emamagic.safe.connectivity

internal interface ConnectivityPublisherDelegate {
    fun receiveConnectivity(connectivity: Connectivity)
}