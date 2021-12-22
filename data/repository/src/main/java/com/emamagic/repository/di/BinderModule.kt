package com.emamagic.repository.di

import com.emamagic.domain.repository.ConfigRepository
import com.emamagic.repository.repository.ConfigRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BinderModule {

    @Binds
    abstract fun bindConfigRepository(configRepositoryImpl: ConfigRepositoryImpl): ConfigRepository

}