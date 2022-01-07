package com.emamagic.signin.contract

import com.emamagic.core.base.BaseState

data class SigninState(
    val test: Boolean
) : BaseState {
    companion object {
        fun initialize() = SigninState(false)
    }

}
