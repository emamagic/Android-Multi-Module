package com.emamagic.common_android.di

import android.app.Application
import com.emamagic.network.di.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    fun inject(app: Application)

}