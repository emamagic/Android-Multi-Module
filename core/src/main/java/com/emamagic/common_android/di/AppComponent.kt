package com.emamagic.common_android.di

import com.emamagic.network.di.RetrofitModule
import com.emamagic.repository.di.BinderModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, BinderModule::class])
interface AppComponent {

    fun getSigninComponent(): SigninComponent

}