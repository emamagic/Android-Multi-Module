package com.emamagic.signin.di

import com.emamagic.core.utils.FragmentScope
import com.emamagic.signin.FirstFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface SigninComponent {

    fun inject(firstFragment: FirstFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : SigninComponent
    }

}