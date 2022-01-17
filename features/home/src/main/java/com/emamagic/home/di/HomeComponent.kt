package com.emamagic.home.di

import com.emamagic.core.utils.FragmentScope
import com.emamagic.home.HomeFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : HomeComponent
    }

}