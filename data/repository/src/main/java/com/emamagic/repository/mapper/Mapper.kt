package com.emamagic.repository.mapper

import com.emamagic.common_entity.Config
import com.emamagic.network.dto.ConfigDto
import retrofit2.Response

fun ConfigDto.mapToConfig(): Config =
    Config(
        fileServerUrl = this.config.fileServerUrl,
        videoCallType = this.config.videoCallType,
        deploymnetType = this.config.deploymnetType,
        compatibleVersion = this.config.compatibleVersion
    )
