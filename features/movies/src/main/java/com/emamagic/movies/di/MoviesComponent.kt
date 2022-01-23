package com.emamagic.movies.di

import com.emamagic.core.utils.ViewModelScope
import com.emamagic.movies.MoviesFragment
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [ViewModelModule::class])
interface MoviesComponent {

    fun inject(moviesFragment: MoviesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MoviesComponent
    }

}