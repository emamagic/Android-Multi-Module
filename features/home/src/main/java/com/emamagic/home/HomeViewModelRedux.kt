package com.emamagic.home

import androidx.lifecycle.viewModelScope
import com.emamagic.core.base.BaseViewModelRedux
import com.emamagic.core.interactor.HomeUseCase
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import com.emamagic.home.contract.redux.HomeStore
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModelRedux @Inject constructor(
    private val store: HomeStore
): BaseViewModelRedux<HomeState, HomeEvent, HomeStore>() {

    init {
//        getGenre()
    }

    override fun createStore(): HomeStore = store


    private fun getGenre() = viewModelScope.launch {
        store.dispatch(HomeEvent.GetGenre)
    }

}