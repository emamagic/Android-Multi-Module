package com.emamagic.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import com.emamagic.home.databinding.FragmentHomeBinding
import com.emamagic.home.di.HomeComponentProvider

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeState, HomeEvent, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

    override fun getResId(): Int = R.layout.fragment_home


    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<HomeComponentProvider>().provideHomeComponent().inject(this)
    }


    override fun renderViewState(viewState: HomeState) {

    }

}