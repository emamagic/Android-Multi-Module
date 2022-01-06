package com.emamagic.signin.di

import androidx.lifecycle.ViewModel
import com.emamagic.core.utils.ViewModelKey
import com.emamagic.signin.phone_number.PhoneNumberViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhoneNumberViewModel::class)
    abstract fun firstViewModel(viewModel: PhoneNumberViewModel): ViewModel
}