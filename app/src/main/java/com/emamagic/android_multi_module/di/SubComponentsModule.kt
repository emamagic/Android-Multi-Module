package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.movies.di.MoviesComponent
import dagger.Module

@Module(
    subcomponents = [
        HomeComponent::class,
        MoviesComponent::class
    ]
)
class SubComponentsModule