package com.emamagic.domain.interactor

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.repository.ConfigRepository
import javax.inject.Inject

class GetConfig @Inject constructor(
    private val repository: ConfigRepository
) {

    suspend operator fun invoke(): ResultWrapper<Config> = repository.getConfig()

}