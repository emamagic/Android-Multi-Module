package com.emamagic.safe.policy

data class CachePolicy(
    val type: Type? = Type.ALWAYS,
    val expires: Long = 0,
    val createAt: Long = 0
) {
    enum class Type {
        NEVER, // never create a cache line for the key
        ALWAYS, // always create a cache line for the key
        REFRESH, // re-fetch (refresh) the cache line for the key
        CLEAR, // clear the cache line for the key
        EXPIRES, // expire this cache line and refresh if older than expires,
        CUSTOM // we should define customize should fetch
    }
}