package com.emamagic.domain

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper

interface ConfigRepository {

    suspend fun getConfig(): ResultWrapper<Config>

}