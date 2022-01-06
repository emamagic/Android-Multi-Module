package com.emamagic.android_multi_module.di

import com.emamagic.signin.di.SigninComponent
import dagger.Module

@Module(
    subcomponents = [
        SigninComponent::class
    ]
)
class SubComponentsModule {
}