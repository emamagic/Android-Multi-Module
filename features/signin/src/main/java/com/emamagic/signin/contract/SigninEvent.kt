package com.emamagic.signin.contract

import com.emamagic.core.base.BaseEvent

sealed class SigninEvent: BaseEvent {
    object NavigateToHome : SigninEvent()
    object CustomEvent : SigninEvent()
}
