package com.emamagic.signin.di

import com.emamagic.core.utils.FragmentScope
import com.emamagic.signin.SigninFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface SigninComponent {

    fun inject(signinFragment: SigninFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : SigninComponent
    }

}