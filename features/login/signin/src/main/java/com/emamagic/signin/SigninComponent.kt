package com.emamagic.signin

import com.emamagic.core.utils.FragmentScope
import com.emamagic.view_interactor.AppComponent
import com.emamagic.view_interactor.ViewModelFactoryBinderModule
import dagger.Component

@FragmentScope
@Component(modules = [ViewModelFactoryBinderModule::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface SigninComponent {

    fun inject(firstFragment: FirstFragment)

}