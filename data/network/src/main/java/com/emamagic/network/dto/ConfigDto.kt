package com.emamagic.network.dto

data class ConfigDto(val config: Config)
data class Config(
    val fileServerUrl: String,
    val videoCallType: String,
    val deploymnetType: String,
    val compatibleVersion: String? = null
)