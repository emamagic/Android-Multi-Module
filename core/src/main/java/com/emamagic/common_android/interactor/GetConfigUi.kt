package com.emamagic.common_android.interactor

import com.emamagic.common_entity.Config
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.interactor.GetConfig
import com.emamagic.domain.repository.ConfigRepository
import javax.inject.Inject

class GetConfigUi @Inject constructor(
    private val getConfig: GetConfig
){

    suspend operator fun invoke(): ResultWrapper<Config> = getConfig()
}