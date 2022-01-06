package com.emamagic.signin.phone_number.contract

import com.emamagic.core.base.BaseState

data class PhoneNumberState(
    val test: Boolean
) : BaseState {
    companion object {
        fun initialize() = PhoneNumberState(false)
    }

}
