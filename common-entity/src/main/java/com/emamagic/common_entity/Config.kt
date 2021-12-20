package com.emamagic.common_entity

data class Config(
    val fileServerUrl: String,
    val videoCallType: String,
    val deploymnetType: String,
    val compatibleVersion: String? = null
)