package com.emamagic.signin

import com.emamagic.core.utils.FragmentScope
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