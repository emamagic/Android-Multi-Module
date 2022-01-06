package com.emamagic.android_multi_module

import androidx.multidex.MultiDexApplication
import com.emamagic.android_multi_module.di.AppComponentProvider
import com.emamagic.android_multi_module.di.SubComponents

class App: MultiDexApplication(), SubComponents {

    override fun onCreate() {
        super.onCreate()
        AppComponentProvider.provideAppComponent(this)
    }

}