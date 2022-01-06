package com.emamagic.signin.di

import com.emamagic.core.utils.FragmentScope
import com.emamagic.signin.phone_number.PhoneNumberFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface SigninComponent {

    fun inject(phoneNumberFragment: PhoneNumberFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : SigninComponent
    }

}