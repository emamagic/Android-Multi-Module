package com.emamagic.signin.contract

import com.emamagic.core.base.BaseEvent

sealed class SiginEvent: BaseEvent {
    object NavigateToSingUp : SiginEvent()
    object CustomEvent : SiginEvent()
}
