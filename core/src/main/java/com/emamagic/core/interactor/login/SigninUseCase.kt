package com.emamagic.core.interactor.login

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.interactor.GetConfig
import javax.inject.Inject

class SigninUseCase @Inject constructor(
    private val getConfig: GetConfig
) {

    suspend fun getConfig(): ResultWrapper<Config> = getConfig.execute()

}