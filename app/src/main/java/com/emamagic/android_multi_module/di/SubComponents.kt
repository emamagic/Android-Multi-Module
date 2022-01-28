package com.emamagic.android_multi_module.di

import com.emamagic.home.di.HomeComponent
import com.emamagic.home.di.HomeComponentProvider
import com.emamagic.movie.di.MovieComponent
import com.emamagic.movie.di.MovieComponentProvider
import com.emamagic.movies.di.MoviesComponent
import com.emamagic.movies.di.MoviesComponentProvider

interface SubComponents: HomeComponentProvider, MoviesComponentProvider, MovieComponentProvider {

    override fun provideHomeComponent(): HomeComponent =
         AppComponentProvider.appComponent().homeComponent().create()

    override fun provideMoviesComponent(): MoviesComponent =
        AppComponentProvider.appComponent().moviesComponent().create()

    override fun provideMovieComponent(): MovieComponent =
        AppComponentProvider.appComponent().movieComponent().create()

}