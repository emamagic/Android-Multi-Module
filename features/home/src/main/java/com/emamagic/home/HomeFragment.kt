package com.emamagic.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.extension.findComponent
import com.emamagic.core.utils.Logger
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import com.emamagic.home.contract.redux.HomeStore
import com.emamagic.home.databinding.FragmentHomeBinding
import com.emamagic.home.di.HomeComponentProvider

class HomeFragment: BaseFragmentRedux<FragmentHomeBinding, HomeState, HomeAction, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

    override fun getResId(): Int = R.layout.fragment_home


    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<HomeComponentProvider>().provideHomeComponent().inject(this)

    }


    override fun renderViewState(viewState: HomeState) {

        when (viewState.movieCategory) {
            MovieCategory.TOP_IMDB -> {}
            MovieCategory.SERIES -> {
                viewState.movies.forEach { series ->
                    binding.recyclerViewSeries.withModels {
                        movie {
                            id(series.id)
                            movie(series)
                        }
                    }
                }
            }
            MovieCategory.ANIMATION -> {}
            MovieCategory.POPULAR -> {}
        }

        viewState.genres.forEach { genre ->
            binding.recyclerViewGenre.withModels {
                genre {
                    id(genre.id)
                    genre(genre)
                }
            }
        }


    }

}