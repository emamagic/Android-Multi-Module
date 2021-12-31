package com.emamagic.signin

import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.interactor.login.SigninUseCase
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private val signInUseCase: SigninUseCase
): BaseViewModel() {

    suspend fun getConfig() = signInUseCase.getConfig()

}