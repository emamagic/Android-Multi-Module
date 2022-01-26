package com.emamagic.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.base.HomeEffect
import com.emamagic.core.extension.findComponent
import com.emamagic.core.extension.gone
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
        binding.viewModel = viewModel
        setUpRecyclerView()
    }

    override fun renderViewState(viewState: HomeState) {
        binding.recyclerViewTopMovieImdb.withModels {
            viewState.topImdbMovies.forEach { topMovie ->
                movieV {
                    id(topMovie.id)
                    movie(topMovie)
                    onClickListener { _ ->

                    }
                }
            }
        }
        binding.recyclerViewSeries.withModels {
            viewState.series.forEach { movie ->
                movieH {
                    id(movie.id)
                    movie(movie)
                    onClickListener { _ ->

                    }
                }
            }
        }
        binding.recyclerViewAnimation.withModels {
            viewState.animations.forEach { animation ->
                movieV {
                    id(animation.id)
                    movie(animation)
                    onClickListener { _ ->

                    }
                }
            }
        }
        binding.recyclerViewPopularMovie.withModels {
            viewState.popularMovies.forEach { papular ->
                movieH {
                    id(papular.id)
                    movie(papular)
                    onClickListener { _ ->

                    }
                }
            }

        }
        binding.recyclerViewGenre.withModels {
            viewState.genres.forEach { genre ->
                genre {
                    id(genre.id)
                    genre(genre)
                    onClickListener { _ ->

                    }
                }
            }
        }
    }

    override fun renderCustomViewEffect(viewEffect: BaseEffect): Boolean {
        when (viewEffect) {
            is HomeEffect.StopShimmer -> stopShimmer()
        }
        return true
    }

    private fun stopShimmer() {
        binding.shimmerFrameLayoutGenre.hideShimmer()
        binding.shimmerFrameLayoutTop.hideShimmer()
        binding.shimmerFrameLayoutPopular.hideShimmer()
        binding.shimmerFrameLayoutAnim.hideShimmer()
        binding.shimmerFrameLayoutSeries.hideShimmer()
        binding.shimmerFrameLayoutGenre.gone()
        binding.shimmerFrameLayoutTop.gone()
        binding.shimmerFrameLayoutPopular.gone()
        binding.shimmerFrameLayoutAnim.gone()
        binding.shimmerFrameLayoutSeries.gone()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewTopMovieImdb.setHasFixedSize(true)
        binding.recyclerViewSeries.setHasFixedSize(true)
        binding.recyclerViewAnimation.setHasFixedSize(true)
        binding.recyclerViewPopularMovie.setHasFixedSize(true)
        binding.recyclerViewGenre.setHasFixedSize(true)
    }

}