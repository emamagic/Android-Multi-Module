package com.emamagic.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.common_jvm.GenreCategory
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.extension.findComponent
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

        setUpRecyclerView()

    }

    override fun onResume() {
        super.onResume()
        val dummyTimeout = 4000L
        startShimmers()
        Handler(Looper.getMainLooper()).postDelayed({
            hideShimmer()
        }, dummyTimeout)
    }


    override fun renderViewState(viewState: HomeState) {

        when (viewState.movieCategory) {
            MovieCategory.TOP_IMDB -> {
                binding.recyclerViewTopMovieImdb.withModels {
                    viewState.movies.forEach { topMovie ->
                        movieV {
                            id(topMovie.id)
                            movie(topMovie)
                            onClickListener { _ ->
                                movieClicked(topMovie.categoryName!!)
                            }
                        }
                    }
                }
            }
            MovieCategory.SERIES -> {
                binding.recyclerViewSeries.withModels {
                    viewState.movies.forEach { movie ->
                        movieH {
                            id(movie.id)
                            movie(movie)
                            onClickListener { _ ->
                                movieClicked(movie.categoryName!!)
                            }
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
                            movieClicked(animation.categoryName!!)
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
                            movieClicked(papular.categoryName!!)
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
                    genreClicked(genre.name)
                }
            }
        }
    }

    private fun movieClicked(@MovieCategory category: String) {
        viewModel.movieClickEvent(category)
    }

    private fun genreClicked(@GenreCategory category: String) {
        viewModel.genreClickEvent(category)
    }

    private fun startShimmers() {
        binding.shimmerFrameLayoutGenre.startShimmer()
        binding.shimmerFrameLayoutTop.startShimmer()
        binding.shimmerFrameLayoutSeries.startShimmer()
        binding.shimmerFrameLayoutAnim.startShimmer()
        binding.shimmerFrameLayoutPopular.startShimmer()
    }

    private fun hideShimmer() {
        binding.shimmerFrameLayoutGenre.hideShimmer()
        binding.shimmerFrameLayoutTop.hideShimmer()
        binding.shimmerFrameLayoutPopular.hideShimmer()
        binding.shimmerFrameLayoutAnim.hideShimmer()
        binding.shimmerFrameLayoutSeries.hideShimmer()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewTopMovieImdb.setHasFixedSize(true)
        binding.recyclerViewSeries.setHasFixedSize(true)
        binding.recyclerViewAnimation.setHasFixedSize(true)
        binding.recyclerViewPopularMovie.setHasFixedSize(true)
        binding.recyclerViewGenre.setHasFixedSize(true)
    }

}