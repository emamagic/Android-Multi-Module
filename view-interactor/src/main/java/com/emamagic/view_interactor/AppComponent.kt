package com.emamagic.view_interactor

import com.emamagic.domain.repository.ConfigRepository
import com.emamagic.network.di.RetrofitModule
import com.emamagic.repository.di.RepositoryBinderModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, RepositoryBinderModule::class])
interface AppComponent {

    fun provideConfigRepository(): ConfigRepository

}