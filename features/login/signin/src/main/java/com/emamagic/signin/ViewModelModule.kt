package com.emamagic.signin

import androidx.lifecycle.ViewModel
import com.emamagic.common_android.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun firstViewModel(viewModel: FirstViewModel): ViewModel
}