package com.emamagic.safe.connectivity

internal object ConnectivityPublisher {
    private val subscribers = Connectivity.IDS.map { mutableListOf<ConnectivityPublisherDelegate>() }

    fun subscribe(subscriber: ConnectivityPublisherDelegate, id: Int) = subscribers[id].add(subscriber)

    fun unSubscribe(subscriber: ConnectivityPublisherDelegate, id: Int) = subscribers[id].remove(subscriber)

    fun notifySubscribers(connectivity: Connectivity) = subscribers[connectivity.status].forEach { it.receiveConnectivity(connectivity) }
}
