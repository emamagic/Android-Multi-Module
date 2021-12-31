package com.emamagic.core.base

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class ViewModelFactoryBinderModule {

    @Reusable
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}