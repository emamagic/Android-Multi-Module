package com.emamagic.limonad_android.di

import com.emamagic.signin.di.SigninComponent
import dagger.Module

@Module(
    subcomponents = [
        SigninComponent::class
    ]
)
class SubComponentsModule {
}