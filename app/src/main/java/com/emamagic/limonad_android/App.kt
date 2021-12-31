package com.emamagic.limonad_android

import androidx.multidex.MultiDexApplication
import com.emamagic.limonad_android.di.AppComponentProvider
import com.emamagic.limonad_android.di.SubComponents

class App: MultiDexApplication(), SubComponents {

    override fun onCreate() {
        super.onCreate()
        AppComponentProvider.provideAppComponent(this)
    }

}