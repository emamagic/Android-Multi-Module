package com.emamagic.safe.store

import java.util.*

interface ITimeLimitedResource {
    var refreshRate: Long
    val lastUpdate: Date?

    suspend fun evict(cleanup: Boolean = false)
}