package com.emamagic.signin

import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.base.SigninEffect
import com.emamagic.core.interactor.login.SigninUseCase
import com.emamagic.core.utils.exhaustive
import com.emamagic.signin.contract.SiginEvent
import com.emamagic.signin.contract.SigninState
import javax.inject.Inject

class SigninViewModel @Inject constructor(
    private val signInUseCase: SigninUseCase
): BaseViewModel<SigninState, SiginEvent>() {

    override fun createInitialState() = SigninState.initialize()

    override fun handleEvent(event: SiginEvent) {
        when (event) {
            SiginEvent.NavigateToSingUp -> navigateTo(SigninFragmentDirections.actionFirstFragmentToSecondFragment())
            SiginEvent.CustomEvent -> setEffect { SigninEffect.CustomEffect }
            //  setState {  }
        }.exhaustive
    }


    suspend fun getConfig() = signInUseCase.getConfig()


}