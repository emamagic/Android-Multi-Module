package com.emamagic.domain.interactor

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.base.UseCase
import com.emamagic.domain.repository.ConfigRepository
import javax.inject.Inject

class GetConfig @Inject constructor(
    private val configRepository: ConfigRepository
): UseCase<ResultWrapper<Config>>() {

    override suspend fun buildUseCase(): ResultWrapper<Config> = configRepository.getConfig()

}