package com.emamagic.repository.repository

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.ConfigRepository
import com.emamagic.network.service.ConfigService
import com.emamagic.repository.mapper.mapToConfig
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfigRepositoryImpl @Inject constructor(
    private val configService: ConfigService
): SafeApi(), ConfigRepository {


    override suspend fun getConfig(): ResultWrapper<Config> {

    }

}