package com.emamagic.signin.phone_number.contract

import com.emamagic.core.base.BaseEvent

sealed class PhoneNumberEvent: BaseEvent {
    object NavigateToSingUp : PhoneNumberEvent()
    object CustomEvent : PhoneNumberEvent()
}
