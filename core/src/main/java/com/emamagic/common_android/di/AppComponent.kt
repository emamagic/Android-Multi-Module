package com.emamagic.common_android.di

import com.emamagic.network.di.RetrofitModule
import com.emamagic.network.service.ConfigService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    fun getConfigService(): ConfigService

}