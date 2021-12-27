package com.emamagic.repository.di

import com.emamagic.domain.repository.ConfigRepository
import com.emamagic.repository.repository.ConfigRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BinderModule {

    @Singleton
    @Binds
    abstract fun bindConfigRepository(configRepositoryImpl: ConfigRepositoryImpl): ConfigRepository

}