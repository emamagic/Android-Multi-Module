package com.emamagic.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.extension.findComponent
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import com.emamagic.home.contract.redux.HomeStore
import com.emamagic.home.databinding.FragmentHomeBinding
import com.emamagic.home.di.HomeComponentProvider

class HomeFragment: BaseFragmentRedux<FragmentHomeBinding, HomeState, HomeEvent, HomeStore, HomeViewModelRedux>() {

    override val viewModel: HomeViewModelRedux
        get() = ViewModelProvider(this, viewModelFactory)[HomeViewModelRedux::class.java]

    override fun getResId(): Int = R.layout.fragment_home


    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<HomeComponentProvider>().provideHomeComponent().inject(this)

    }


    override fun renderViewState(viewState: HomeState) {

        viewState.series.forEach { topImdb ->
            binding.recyclerViewSeries.withModels {
                movieHorizontal {
                    id(topImdb.id)
                    movie(topImdb)
                }
            }
        }


    }

}