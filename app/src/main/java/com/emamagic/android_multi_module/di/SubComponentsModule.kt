package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import dagger.Module

@Module(
    subcomponents = [
        HomeComponent::class,
    ]
)
class SubComponentsModule