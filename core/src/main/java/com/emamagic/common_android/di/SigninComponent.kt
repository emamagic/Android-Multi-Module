package com.emamagic.common_android.di

import com.emamagic.common_android.interactor.GetConfigUi
import com.emamagic.domain.interactor.GetConfig
import com.emamagic.repository.di.BinderModule
import dagger.Component
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface SigninComponent {

    fun getConfigUi(): GetConfigUi

}