package com.emamagic.home.di

import androidx.lifecycle.ViewModel
import com.emamagic.core.utils.ViewModelKey
import com.emamagic.home.HomeViewModelRedux
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    abstract fun firstViewModel(viewModel: HomeViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModelRedux::class)
    abstract fun firstViewModel(viewModel: HomeViewModelRedux): ViewModel
}