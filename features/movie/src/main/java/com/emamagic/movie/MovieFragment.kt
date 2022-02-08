package com.emamagic.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.core.extension.findComponent
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import com.emamagic.movie.databinding.FragmentMovieBinding
import com.emamagic.movie.di.MovieComponent
import com.emamagic.movie.di.MovieComponentProvider

class MovieFragment: BaseFragmentRedux<FragmentMovieBinding, MovieState, MovieAction, MovieViewModel>() {

    override val viewModel: MovieViewModel
        get() = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

    private val args: MovieFragmentArgs by navArgs()

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<MovieComponentProvider>().provideMovieComponent().inject(this)

        setUpRecyclerViews()

        viewModel.getMovieDetailEvent(args.movieId)
        viewModel.getCastsEvent(args.movieId)
        if (args.movieCategory == MovieCategory.SERIES)
        viewModel.getSeasonsEvent(args.movieId)
    }

    override fun renderViewState(viewState: MovieState) {



    }


    private fun setUpRecyclerViews() {
        binding.recyclerViewCast.setHasFixedSize(true)
        binding.recyclerViewSeason.setHasFixedSize(true)
        binding.recyclerViewSimilar.setHasFixedSize(true)
    }

}