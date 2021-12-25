package com.emamagic.common_android.di

import com.emamagic.domain.interactor.GetConfig
import com.emamagic.repository.di.BinderModule
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [BinderModule::class])
interface SigninComponent {

    fun getConfig(): GetConfig

}