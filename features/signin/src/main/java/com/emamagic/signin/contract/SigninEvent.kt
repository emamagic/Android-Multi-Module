package com.emamagic.signin.contract

import com.emamagic.core.base.BaseEvent

sealed class SigninEvent: BaseEvent {
    object NavigateToSingUp : SigninEvent()
    object CustomEvent : SigninEvent()
}
