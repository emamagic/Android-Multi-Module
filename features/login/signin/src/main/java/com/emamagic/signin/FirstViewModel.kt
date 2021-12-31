package com.emamagic.signin

import androidx.lifecycle.ViewModel
import com.emamagic.core.interactor.login.SigninUseCase
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private val signInUseCase: SigninUseCase
): ViewModel() {

    suspend fun getConfig() = signInUseCase.getConfig()

}