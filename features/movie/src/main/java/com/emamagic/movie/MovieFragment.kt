package com.emamagic.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.base.BaseFragmentRedux
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import com.emamagic.movie.databinding.FragmentMovieBinding

class MovieFragment: BaseFragmentRedux<FragmentMovieBinding, MovieState, MovieAction, MovieViewModel>() {

    override val viewModel: MovieViewModel
        get() = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

    override fun getResId(): Int = R.layout.fragment_movie

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun renderViewState(viewState: MovieState) {

    }
}