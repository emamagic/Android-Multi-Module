package com.emamagic.android_multi_module.di

import com.emamagic.signin.di.SigninComponent
import com.emamagic.signin.di.SigninComponentProvider

interface SubComponents: SigninComponentProvider {

    override fun provideSigninComponent(): SigninComponent {
        return AppComponentProvider.appComponent().signinComponent().create()
    }
}