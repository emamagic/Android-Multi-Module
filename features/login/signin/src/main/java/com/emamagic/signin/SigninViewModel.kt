package com.emamagic.signin

import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.base.SigninEffect
import com.emamagic.core.interactor.login.SigninUseCase
import com.emamagic.core.utils.exhaustive
import com.emamagic.signin.contract.SigninEvent
import com.emamagic.signin.contract.SigninState
import javax.inject.Inject

class SigninViewModel @Inject constructor(
    private val signInUseCase: SigninUseCase
): BaseViewModel<SigninState, SigninEvent>() {

    override fun createInitialState() = SigninState.initialize()

    override fun handleEvent(event: SigninEvent) {
        when (event) {
            SigninEvent.NavigateToSingUp -> navigateTo(SigninFragmentDirections.actionFirstFragmentToSecondFragment())
            SigninEvent.CustomEvent -> setEffect { SigninEffect.CustomEffect }
            //  setState {  }
        }.exhaustive
    }


    suspend fun getConfig() = signInUseCase.getConfig()


}