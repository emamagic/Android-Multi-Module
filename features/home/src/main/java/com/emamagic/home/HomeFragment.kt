package com.emamagic.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.extension.findComponent
import com.emamagic.core.utils.exhaustive
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import com.emamagic.home.databinding.FragmentHomeBinding
import com.emamagic.home.di.HomeComponentProvider

class HomeFragment :
    BaseFragmentRedux<FragmentHomeBinding, HomeState, HomeAction, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

    override fun getResId(): Int = R.layout.fragment_home


    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<HomeComponentProvider>().provideHomeComponent().inject(this)

    }


    override fun renderViewState(viewState: HomeState) {

        when (viewState.movieCategory) {
            MovieCategory.TOP_IMDB ->  {
                binding.recyclerViewTopMovieImdb.withModels {
                    viewState.movies.forEach { topMovie ->
                        movieV {
                            id(topMovie.id)
                            movie(topMovie)
                        }
                    }
                }
            }
            MovieCategory.SERIES ->  {
                binding.recyclerViewSeries.withModels {
                    viewState.movies.forEach { movie ->
                        movieH {
                            id(movie.id)
                            movie(movie)
                        }
                    }
                }
            }
            MovieCategory.ANIMATION -> {
                binding.recyclerViewAnimation.withModels {
                    viewState.movies.forEach { animation ->
                        movieV {
                            id(animation.id)
                            movie(animation)
                        }
                    }
                }
            }
            MovieCategory.POPULAR -> {
                binding.recyclerViewPopularMovie.withModels {
                    viewState.movies.forEach { papular ->
                        movieH {
                            id(papular.id)
                            movie(papular)
                        }
                    }
                }
            }
        }

        binding.recyclerViewGenre.withModels {
            viewState.genres.forEach { genre ->
                genre {
                    id(genre.id)
                    genre(genre)
                }
            }
        }
    }

}