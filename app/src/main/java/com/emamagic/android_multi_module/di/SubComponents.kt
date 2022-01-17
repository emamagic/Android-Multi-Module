package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.home.di.HomeComponentProvider
import com.emamagic.signin.di.SigninComponent
import com.emamagic.signin.di.SigninComponentProvider

interface SubComponents: SigninComponentProvider, HomeComponentProvider {

    override fun provideSigninComponent(): SigninComponent =
         AppComponentProvider.appComponent().signinComponent().create()


    override fun provideHomeComponent(): HomeComponent =
         AppComponentProvider.appComponent().homeComponent().create()

}