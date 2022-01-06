package com.emamagic.android_multi_module.di

import android.app.Application
import com.emamagic.core.base.ViewModelFactoryBinderModule
import com.emamagic.network.di.RetrofitModule
import com.emamagic.repository.di.RepositoryBinderModule
import com.emamagic.signin.di.SigninComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        RepositoryBinderModule::class,
        SubComponentsModule::class,
        ViewModelFactoryBinderModule::class
    ]
)
interface AppComponent {

    // Save the reference of factories in the app component for creating sub components
    fun signinComponent(): SigninComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}