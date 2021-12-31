package com.emamagic.limonad_android.di

import com.emamagic.signin.SigninComponent
import com.emamagic.signin.SigninComponentProvider

interface SubComponents: SigninComponentProvider {

    override fun provideSigninComponent(): SigninComponent {
        return AppComponentProvider.appComponent().signinComponent().create()
    }
}