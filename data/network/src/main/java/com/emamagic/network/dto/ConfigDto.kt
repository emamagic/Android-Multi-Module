package com.emamagic.network.dto

import com.squareup.moshi.Json

data class ConfigDto(val config: Config)
data class Config(
    @Json(name = "file_server_url")
    val fileServerUrl: String,
    @Json(name = "video_call_type")
    val videoCallType: String,
    @Json(name = "app.minCompatibleVersion")
    val deploymnetType: String,
    @Json(name = "compatible_version")
    val compatibleVersion: String? = null
)