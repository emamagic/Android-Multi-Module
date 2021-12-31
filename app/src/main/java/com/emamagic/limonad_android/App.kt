package com.emamagic.limonad_android

import androidx.multidex.MultiDexApplication
import com.emamagic.limonad_android.di.DiProvider
import com.emamagic.limonad_android.di.SubComponents
import timber.log.Timber

class App: MultiDexApplication(), SubComponents {


    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        DiProvider.buildDi(this)
    }

}