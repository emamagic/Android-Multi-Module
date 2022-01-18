package com.emamagic.repository.di

import com.emamagic.domain.repository.GenreRepository
import com.emamagic.domain.repository.MovieDetailRepository
import com.emamagic.domain.repository.MovieRepository
import com.emamagic.repository.repository.GenreRepositoryImpl
import com.emamagic.repository.repository.MovieDetailRepositoryImpl
import com.emamagic.repository.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBinderModule {

    @Binds
    abstract fun bindGenreRepository(genreRepositoryImpl: GenreRepositoryImpl): GenreRepository

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindGenreRepository(movieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository
}