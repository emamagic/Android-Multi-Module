package com.emamagic.signin.phone_number

import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.base.SigninEffect
import com.emamagic.core.interactor.login.SigninUseCase
import com.emamagic.core.utils.exhaustive
import com.emamagic.signin.FirstFragmentDirections
import com.emamagic.signin.phone_number.contract.PhoneNumberEvent
import com.emamagic.signin.phone_number.contract.PhoneNumberState
import javax.inject.Inject

class PhoneNumberViewModel @Inject constructor(
    private val signInUseCase: SigninUseCase
): BaseViewModel<PhoneNumberState, PhoneNumberEvent>() {

    override fun createInitialState() = PhoneNumberState.initialize()

    override fun handleEvent(event: PhoneNumberEvent) {
        when (event) {
            PhoneNumberEvent.NavigateToSingUp -> navigateTo(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
            PhoneNumberEvent.CustomEvent -> setEffect { SigninEffect.CustomEffect }
        }.exhaustive
    }


    suspend fun getConfig() = signInUseCase.getConfig()


}