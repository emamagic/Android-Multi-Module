package com.emamagic.movies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.navArgs
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.movies.contract.MoviesEvent
import com.emamagic.movies.contract.MoviesState
import com.emamagic.movies.databinding.FragmentMoviesBinding
import com.emamagic.movies.di.MoviesComponentProvider

class MoviesFragment :
    BaseFragment<FragmentMoviesBinding, MoviesState, MoviesEvent, MoviesViewModel>() {

    override val viewModel: MoviesViewModel
        get() = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

    private val args: MoviesFragmentArgs by navArgs()

    override fun getResId(): Int = R.layout.fragment_movies

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<MoviesComponentProvider>().provideMoviesComponent().inject(this)

    }

    override fun renderViewState(viewState: MoviesState) {

    }


}