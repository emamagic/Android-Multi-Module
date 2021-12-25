package com.emamagic.limonad_android

import androidx.multidex.MultiDexApplication
import com.emamagic.common_android.di.AppComponent
import com.emamagic.common_android.di.AppComponentProvider
import com.emamagic.common_android.di.DaggerAppComponent
import timber.log.Timber

class App: MultiDexApplication(), AppComponentProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        appComponent = DaggerAppComponent.create()

    }

    override fun provideAppComponent(): AppComponent = appComponent

}