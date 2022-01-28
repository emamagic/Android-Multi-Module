package com.emamagic.movie.di

import androidx.lifecycle.ViewModel
import com.emamagic.core.utils.ViewModelKey
import com.emamagic.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun firstViewModel(viewModel: MovieViewModel): ViewModel
}