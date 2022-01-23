package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.home.di.HomeComponentProvider
import com.emamagic.movies.di.MoviesComponent
import com.emamagic.movies.di.MoviesComponentProvider

interface SubComponents: HomeComponentProvider, MoviesComponentProvider {

    override fun provideHomeComponent(): HomeComponent =
         AppComponentProvider.appComponent().homeComponent().create()

    override fun provideMoviesComponent(): MoviesComponent =
        AppComponentProvider.appComponent().moviesComponent().create()

}