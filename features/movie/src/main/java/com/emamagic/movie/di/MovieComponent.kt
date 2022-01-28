package com.emamagic.movie.di

import com.emamagic.core.utils.ViewModelScope
import com.emamagic.movie.MovieFragment
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [ViewModelModule::class])
interface MovieComponent {

    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieComponent
    }

}