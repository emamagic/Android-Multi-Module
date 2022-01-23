package com.emamagic.home.di

import com.emamagic.core.utils.ViewModelScope
import com.emamagic.home.HomeFragment
import dagger.Subcomponent

@ViewModelScope
@Subcomponent(modules = [ViewModelModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : HomeComponent
    }

}