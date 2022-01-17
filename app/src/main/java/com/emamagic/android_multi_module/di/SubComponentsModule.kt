package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.signin.di.SigninComponent
import dagger.Module

@Module(
    subcomponents = [
        SigninComponent::class,
        HomeComponent::class
    ]
)
class SubComponentsModule {
}