package com.emamagic.android_multi_module.di

import android.app.Application

object AppComponentProvider {
    private lateinit var appComponent: AppComponent

    @JvmStatic
    fun appComponent() = appComponent

    fun provideAppComponent(application: Application) {
        appComponent = DaggerAppComponent.factory().create(application)
    }
}