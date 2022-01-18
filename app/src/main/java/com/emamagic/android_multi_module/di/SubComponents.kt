package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.home.di.HomeComponentProvider

interface SubComponents: HomeComponentProvider {

    override fun provideHomeComponent(): HomeComponent =
         AppComponentProvider.appComponent().homeComponent().create()

}