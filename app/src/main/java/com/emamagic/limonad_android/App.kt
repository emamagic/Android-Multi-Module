package com.emamagic.limonad_android

import androidx.multidex.MultiDexApplication
import com.emamagic.view_interactor.AppComponent
import com.emamagic.view_interactor.AppComponentProvider
import com.emamagic.view_interactor.DaggerAppComponent
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